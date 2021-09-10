package ua.com.alevel.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.FileTypeOwner;
import ua.com.alevel.entity.Owner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service("JsonOwnerDao")
public class JsonOwnerDao extends AbstractDao implements OwnerDao, FileIO {

    @Override
    public void create(Owner owner) {
        loadOwners();
        createOwner(owner);
        storeOwners();
    }

    @Override
    public void update(Owner owner) {
        loadOwners();
        updateOwner(owner);
        storeOwners();
    }

    @Override
    public void delete(String id) {
        loadOwners();
        deleteDelete(id);
        storeOwners();
    }

    @Override
    public Owner findById(String id) {
        loadOwners();
        return findOwnerById(id);
    }

    @Override
    public boolean existByEmail(String email) {
        loadOwners();
        return existOwnerByEmail(email);
    }

    @Override
    public List<Owner> findAll() {
        loadOwners();
        return findAllOwners();
    }

    @Override
    public void loadOwners() {
        super.owners.clear();
        try {
            String ownersOut = FileUtils.readFileToString(new File(FileTypeOwner.JSON_TYPE.getPath()), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            super.owners = objectMapper.readValue(ownersOut, new TypeReference<>() { });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeOwners() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
                .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime()))
                .create();
        String ownersOut = gson.toJson(owners);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FileTypeOwner.JSON_TYPE.getPath()))) {
            writer.append(ownersOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
