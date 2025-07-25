package com.trackcalories.model;

public class User {
    private String name;
    private int age;
    private String gender;
    private int height;        // in cm
    private int weight;        // in kg
    private int targetWeight;  // in kg

    public User() {}

    public User(String name, int age, String gender, int height, int weight, int targetWeight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.targetWeight = targetWeight;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTargetWeight() {
        return targetWeight;
    }
    public void setTargetWeight(int targetWeight) {
        this.targetWeight = targetWeight;
    }
}
