package ua.com.alevel.config;

public enum FileTypeCar {

    JSON_TYPE("cars.json"),
    CSV_TYPE("cars.csv");

    private final String path;

    FileTypeCar(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
