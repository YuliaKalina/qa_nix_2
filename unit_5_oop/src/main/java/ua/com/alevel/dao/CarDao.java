package ua.com.alevel.dao;

import ua.com.alevel.db.CarsDB;
import ua.com.alevel.entity.Car;

import java.util.Optional;

public class CarDao {
    private final CarsDB db = new CarsDB();

    public void create(Car car) {
        db.create(car);
    }

    public void update(Car car) {
        db.update(car);
    }

    public void delete(String id) {
        db.delete(id);
    }

    public Optional<Car> findById(String id) {
        return db.findCarById(id);
    }

    public Car[] findAll() {
        return db.findAll();
    }
}
