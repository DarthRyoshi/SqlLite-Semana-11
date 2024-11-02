package com.example.sqllite;

public class DataModel {
    private int id;
    private String name;
    private int age;
    private String rut;

    public DataModel(int id, String name, int age, String rut) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.rut = rut;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRut() {
        return rut;
    }
}
