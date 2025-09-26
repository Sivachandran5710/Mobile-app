package com.example.e_commerce.models;

public class Product {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    // Getters
    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public String getImage() { return image; }
    public String getCategory() { return category; }
}
