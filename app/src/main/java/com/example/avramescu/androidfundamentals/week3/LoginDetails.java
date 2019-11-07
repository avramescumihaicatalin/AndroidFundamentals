package com.example.avramescu.androidfundamentals.week3;

public class LoginDetails {
    String email;
    String phone;
    boolean terms;

    public LoginDetails(String email, String phone, boolean terms){
        this.email = email;
        this.phone = phone;
        this.terms = terms;
    }

    @Override
    public String toString(){
        return "Email: " + this.email + "\n" + "Phone: " + phone + "\n" + "Terms: " + (terms==true ? "accepted":"not accepted");
    }
}
