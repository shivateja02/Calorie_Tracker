package com.trackcalories.model;

import java.sql.Date;
import java.sql.Time;

public class DailyLog {
    private int id;
    private int userId;
    private Date logDate;
    private Time wakeupTime;
    private String exerciseType;
    private int exerciseDuration;
    private double waterIntake;
    private String breakfastType;
    private String lunchType;
    private String dinnerType;
    private String junkFood;
    private String notes;
    private int caloriesEstimated;

    // Default constructor
    public DailyLog() {}

    // Getters and Setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getLogDate() {
        return logDate;
    }
    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public Time getWakeupTime() {
        return wakeupTime;
    }
    public void setWakeupTime(Time wakeupTime) {
        this.wakeupTime = wakeupTime;
    }

    public String getExerciseType() {
        return exerciseType;
    }
    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public int getExerciseDuration() {
        return exerciseDuration;
    }
    public void setExerciseDuration(int exerciseDuration) {
        this.exerciseDuration = exerciseDuration;
    }

    public double getWaterIntake() {
        return waterIntake;
    }
    public void setWaterIntake(double waterIntake) {
        this.waterIntake = waterIntake;
    }

    public String getBreakfastType() {
        return breakfastType;
    }
    public void setBreakfastType(String breakfastType) {
        this.breakfastType = breakfastType;
    }

    public String getLunchType() {
        return lunchType;
    }
    public void setLunchType(String lunchType) {
        this.lunchType = lunchType;
    }

    public String getDinnerType() {
        return dinnerType;
    }
    public void setDinnerType(String dinnerType) {
        this.dinnerType = dinnerType;
    }

    public String getJunkFood() {
        return junkFood;
    }
    public void setJunkFood(String junkFood) {
        this.junkFood = junkFood;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getCaloriesEstimated() {
        return caloriesEstimated;
    }
    public void setCaloriesEstimated(int caloriesEstimated) {
        this.caloriesEstimated = caloriesEstimated;
    }
}
