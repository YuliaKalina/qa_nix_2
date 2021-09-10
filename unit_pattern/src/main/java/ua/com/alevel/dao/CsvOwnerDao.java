package ua.com.alevel.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.FileTypeOwner;
import ua.com.alevel.entity.Owner;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("CsvOwnerDao")
public class CsvOwnerDao extends AbstractDao implements OwnerDao, FileIO {

    private final List<String[]> csvData = new ArrayList<>();

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
        try(CSVReader reader = new CSVReader(new FileReader(FileTypeOwner.CSV_TYPE.getPath()))) {
            super.owners.clear();
            List<String[]> res = reader.readAll();
            for (String[] re : res) {
                try {
                    Owner owner = Owner.newOwner()
                            .setId(re[0])
                            .setFirstName(re[1])
                            .setLastName(re[2])
                            .setEmail(re[3])
                            .setBirthDay(new Date(Long.parseLong(re[4])))
                            .setCarId(re[5])
                            .build();
                    super.owners.add(owner);
                } catch (Exception e) {
                    System.out.println("e = " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeOwners() {
        this.csvData.clear();
        writeHeader();
        for (Owner u : super.owners) {
            String[] currentOwner = new String[5];
            currentOwner[0] = u.getId();
            currentOwner[1] = u.getFirstName();
            currentOwner[2] = u.getLastName();
            currentOwner[3] = u.getEmail();
            currentOwner[4] = String.valueOf(u.getBirthDay().getTime());
            csvData.add(currentOwner);
        }
        try(CSVWriter writer = new CSVWriter(new FileWriter(FileTypeOwner.CSV_TYPE.getPath()))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHeader() {
        String[] header = { "id", "firstName", "lastName", "email", "birthDay" };
        csvData.add(header);
    }
}
