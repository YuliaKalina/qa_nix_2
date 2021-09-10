package ua.com.alevel.service;

import ua.com.alevel.entity.Car;

import java.util.List;

public interface CarService {
    void create(Car car);
    void update(Car car);
    void delete(String id);
    Car findById(String id);
    List<Car> findAll();
}
