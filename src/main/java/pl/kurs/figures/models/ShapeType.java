package pl.kurs.figures.models;

public enum ShapeType {
    CIRCLE("circle"),
    SQUARE("square"),
    RECTANGLE("rectangle");

    private String name;

    ShapeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
