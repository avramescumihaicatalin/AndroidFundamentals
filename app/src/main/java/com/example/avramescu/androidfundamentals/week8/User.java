package com.example.avramescu.androidfundamentals.week8;// Gradle dependencies

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("login")
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getUser() {
        return name;
    }

    public void setUser(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}