package com.example.nongsan.data.dao.model;

public class OrderDetail {
    public int id;
    public String name;
    public double price;
    public int quantity;
    public String image;
    public int categoryId;

    public OrderDetail(int id, String name, double price, int quantity, String image, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.categoryId = categoryId;
    }
}
