package ua.com.alevel.config;

public enum FileTypeOwner {

    JSON_TYPE("owners.json"),
    CSV_TYPE("owners.csv");

    private final String path;

    FileTypeOwner(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
