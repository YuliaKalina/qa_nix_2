package ua.com.alevel.entity;

public class Car {

    private String id;
    private String brand;
    private String model;
    private String year;
    private String color;

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

    public class Builder {

        private Builder() { }

        public Builder setId(String id) {
            Car.this.id = id;
            return this;
        }

        public Builder setBrand(String brand) {
            Car.this.brand = brand;
            return this;
        }

        public Builder setModel(String model) {
            Car.this.model = model;
            return this;
        }

        public Builder setYear(String year) {
            Car.this.year = year;
            return this;
        }

        public Builder setColor(String color) {
            Car.this.color = color;
            return this;
        }

        public Car build() {
            return Car.this;
        }
    }
}
