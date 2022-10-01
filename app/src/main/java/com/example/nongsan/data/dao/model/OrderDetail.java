package com.example.nongsan.data.dao.model;

public class OrderDetail {
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE orders_details (" +
                    "id INTEGER PRIMARY KEY," +
                    "name TEXT," +
                    "quantity INTEGER,"+
                    "price NUMERIC,"+
                    "image TEXT," +
                    "product_id INTEGER)";
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS orders_details";
    public int id;
    public String name;
    public double price;
    public int quantity;
    public String image;
    public int productId;

<<<<<<< HEAD
    public OrderDetail(int id, String name, double price, int quantity, String image, int categoryId) {
=======
    public OrderDetail(int id, String name, int quantity, double price, String image, int productId) {
>>>>>>> e5b1c74 (order)
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.productId = productId;
    }
}
