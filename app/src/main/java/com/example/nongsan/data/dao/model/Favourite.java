package com.example.nongsan.data.dao.model;

public class Favourite {
    public int id;
    public String name;
    public double price;
    public String image;
    public int categoryId;

    public Favourite(int id, String name, double price, String image, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.categoryId = categoryId;
    }
}
