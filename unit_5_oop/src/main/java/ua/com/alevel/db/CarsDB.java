package ua.com.alevel.db;

import ua.com.alevel.entity.Car;

import java.util.Optional;
import java.util.UUID;
import java.util.Arrays;

public class CarsDB {

    private Car[] cars = new Car[0];

    public void create(Car car) {
        this.extend();
        car.setId(generateId());
        cars[cars.length - 1] = car;
        System.out.println("Created: " + car);
    }

    private void extend(){
        Car [] temp = cars.clone();
        cars = new Car[cars.length + 1];
        System.arraycopy(temp, 0, cars, 0, temp.length);
    }

    public void update(Car car) {
        Optional<Car> temp = findCarById(car.getId());

        if (temp.isEmpty()) {
            System.out.println("A car outside of the database cannot be updated");
            return;
        }

        temp.get().setYear(car.getYear());
        temp.get().setBrand(car.getBrand());
        temp.get().setColor(car.getColor());

        System.out.println("Updated: " + temp.get());
    }

    public void delete(String id) {
        this.cars = Arrays.stream(this.cars)
                .dropWhile(car -> car.getId().equals(id))
                .toArray(Car[]::new);

        System.out.println("The " + id + " is deleted. ");
    }

    public Optional<Car> findCarById(String id) {
        return Arrays.stream(this.cars).filter(
                car -> car.getId().equals(id)
        ).findFirst();
    }

    public Car[] findAll() {
        return this.cars;
    }

    private String generateId() {
        // uniq - https://towardsdatascience.com/are-uuids-really-unique-57eb80fc2a87
        return UUID.randomUUID().toString();
    }
}