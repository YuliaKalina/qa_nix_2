package ua.com.alevel.dao;

import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.Owner;

import java.util.List;

public interface CarDao {

    void create(Car car);
    void update(Car car);
    void delete(String id);
    Car findById(String id);
    boolean existByBrand(String brand);
    List<Car> findAll();
}
