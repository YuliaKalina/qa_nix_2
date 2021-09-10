package ua.com.alevel.dao;

import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractDao {

    protected List<Owner> owners = new ArrayList<>();
    protected List<Car> cars = new ArrayList<>();

    protected void createOwner(Owner owner) {
        owner.setId(generateId());
        owners.add(owner);
    }

    protected void createCar(Car car) {
        car.setId(generateId());
        cars.add(car);
    }

    protected void updateOwner(Owner owner) {
        if (existById(owner.getId())) {
            Owner current = findOwnerById(owner.getId());
            current.setId(owner.getId());
            current.setFirstName(owner.getFirstName());
            current.setLastName(owner.getLastName());
            current.setEmail(owner.getEmail());
            current.setBirthDay(owner.getBirthDay());
        }
    }

    protected void updateCar(Car car) {
        if (existById(car.getId())) {
            Car current = findCarById(car.getId());
            current.setId(car.getId());
            current.setColor(car.getColor());
            current.setYear(car.getYear());
            current.setModel(car.getModel());
            current.setBrand(car.getBrand());
        }
    }

    protected void deleteDelete(String id) {
        owners.removeIf(owner -> owner.getId().equals(id));
    }
    protected void deleteDelete2(String id) {
        cars.removeIf(car -> car.getId().equals(id));
    }

    protected Owner findOwnerById(String id) {
        return owners.stream().filter(owner -> owner.getId().equals(id)).findFirst().get();
    }

    protected Car findCarById(String id) {
        return cars.stream().filter(car -> car.getId().equals(id)).findFirst().get();
    }

    protected Owner findOwnerByEmail(String email) {
        return owners.stream().filter(owner -> owner.getEmail().equals(email)).findFirst().get();
    }

    protected Car findCarByBrand(String brand) {
        return cars.stream().filter(car -> car.getBrand().equals(brand)).findFirst().get();
    }

    protected List<Owner> findAllOwners() {
        return owners;
    }
    protected List<Car> findAllCars() {
        return cars;
    }

    protected boolean existOwnerByEmail(String email) {
        return owners.stream().anyMatch(owner -> owner.getEmail().equals(email));
    }
    protected boolean existCarByBrand(String brand) {
        return cars.stream().anyMatch(car -> car.getBrand().equals(brand));
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existById(String id) {
        return owners.stream().anyMatch(owner -> owner.getId().equals(id));
    }
    private boolean existById2(String id) {
        return cars.stream().anyMatch(car -> car.getId().equals(id));
    }
}
