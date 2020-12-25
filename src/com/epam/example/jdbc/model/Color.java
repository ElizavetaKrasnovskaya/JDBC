package com.epam.example.jdbc.model;

public class Color {
    private int id;
    private String name;

    public Color(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Color" +
                " id = " + id +
                ", name = " + name;
    }
}
