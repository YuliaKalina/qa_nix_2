package ua.com.alevel.service;

import ua.com.alevel.dao.CarDao;
import ua.com.alevel.entity.Car;

import java.util.Optional;

public class CarService {

    private final CarDao dao = new CarDao();

    public void create(Car car) {
        dao.create(car);
    }

    public void update(Car car) {
        dao.update(car);
    }

    public void delete(String id) {
        dao.delete(id);
    }

    public Optional<Car> findById(String id) {
        return dao.findById(id);
    }

    public Car[] findAll() {
        return dao.findAll();
    }
}