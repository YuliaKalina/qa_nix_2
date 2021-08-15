package ua.com.alevel.entity;

import lombok.Data;

@Data
public class Car {
    private String brand;
    private int year;
    private String id;
    private String color;

    public String tellHistory(){
        return "Car = " + this.getBrand()
                + " is " + this.getColor()
                + " made in " + this.getYear() + "year";
    }
}

