package ua.com.alevel.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.FileTypeCar;
import ua.com.alevel.entity.Car;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service("JsonCarDao")
public class JsonCarDao extends AbstractDao implements CarDao {

    @Override
    public void create(Car car) {
        loadCars();
        createCar(car);
        storeCars();
    }

    @Override
    public void update(Car car) {
        loadCars();
        updateCar(car);
        storeCars();
    }

    @Override
    public void delete(String id) {
        loadCars();
        deleteDelete2(id);
        storeCars();
    }

    @Override
    public Car findById(String id) {
        loadCars();
        return findCarById(id);
    }

    @Override
    public boolean existByBrand(String brand) {
        loadCars();
        return existCarByBrand(brand);
    }

    @Override
    public List<Car> findAll() {
        loadCars();
        return findAllCars();
    }

    public void loadCars() {
        super.cars.clear();
        try {
            String carsOut = FileUtils.readFileToString(new File(FileTypeCar.JSON_TYPE.getPath()), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            super.cars = objectMapper.readValue(carsOut, new TypeReference<>() { });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storeCars() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
                .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime()))
                .create();
        String carsOut = gson.toJson(cars);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FileTypeCar.JSON_TYPE.getPath()))) {
            writer.append(carsOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
