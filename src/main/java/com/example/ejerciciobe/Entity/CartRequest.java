package com.example.ejerciciobe.Entity;

public class CartRequest {
    private String fullName;
    private String email;

    public CartRequest(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }
}
