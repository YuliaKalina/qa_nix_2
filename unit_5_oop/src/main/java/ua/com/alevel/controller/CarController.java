package ua.com.alevel.controller;


import ua.com.alevel.entity.Car;
import ua.com.alevel.service.CarService;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

public class CarController {

    private final CarService carService = new CarService();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create car, please enter 1");
        System.out.println("if you want update car, please enter 2");
        System.out.println("if you want delete car, please enter 3");
        System.out.println("if you want findById car, please enter 4");
        System.out.println("if you want findAll car, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                create(reader);
                break;
            case "2":
                update(reader);
                break;
            case "3":
                delete(reader);
                break;
            case "4":
                findById(reader);
                break;
            case "5":
                findAll();
                break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("CarController.create");
        try {
            System.out.println("Please, enter your car brand");
            String brand = reader.readLine();
            System.out.println("Please, enter your car year");
            String yearString = reader.readLine();
            System.out.println("Please, enter your car color");
            String colorString = reader.readLine();
            int year = Integer.parseInt(yearString.trim());
            Car car = new Car();
            car.setYear(year);
            car.setBrand(brand);
            car.setColor(colorString);
            carService.create(car);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("CarController.update");
        try {
            System.out.println("Please, enter car id");
            String id = reader.readLine();
            System.out.println("Please, enter new brand");
            String brand = reader.readLine();
            System.out.println("Please, enter new year");
            String yearString = reader.readLine();
            System.out.println("Please, enter new color");
            String colorString = reader.readLine();
            int year = Integer.parseInt(yearString.trim());
            Car car = new Car();
            car.setId(id);
            car.setYear(year);
            car.setBrand(brand);
            car.setColor(colorString);
            carService.update(car);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("Car.delete");
        try {
            System.out.println("Please, enter your car id");
            String id = reader.readLine();
            carService.delete(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("CarController.findById");
        try {
            System.out.println("Please, enter car id");
            String id = reader.readLine();
            Optional<Car> car = carService.findById(id);
            if (car.isPresent()) {
                System.out.println(car.get().tellHistory());
            } else {
                System.out.println("No car with this id.");
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll() {
        System.out.println("CarController.findAll");
        System.out.println("You have the following list of cars:");
        Arrays.stream(this.carService.findAll()).forEach(
                car -> System.out.println("Car #" + car.getId().substring(0, 4) + ": " + car.tellHistory())
        );
    }
}