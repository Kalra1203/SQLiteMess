package com.example.databasesqlite.models;

import java.io.Serializable;

public class Model  implements Serializable {
    private String date;
    private String breakfast;
    private String lunch;
    private String snacks;
    private String dinner;

    public Model(String date, String breakfast, String lunch, String snacks, String dinner) {
        this.date = date;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.snacks = snacks;
        this.dinner = dinner;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getSnacks() {
        return snacks;
    }

    public void setSnacks(String snacks) {
        this.snacks = snacks;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }
}