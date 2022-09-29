package com.example.nongsan.data.dao.model;

public class OrderDetail {
    public int id;
    public String name;
    public int quantity;
    public double price;
    public String image;
    public int categoryId;

    public OrderDetail(int id, String name, int quantity, double price, String image, int categoryId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.categoryId = categoryId;
    }
}
