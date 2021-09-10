package ua.com.alevel.dto;

import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.Owner;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class CarResponseDto {

    private String id;
    private String brand;
    private String model;
    private String year;
    private String color;

    public CarResponseDto(Car car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.brand = car.getBrand();
        this.year = car.getYear();
        this.color = car.getColor();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
