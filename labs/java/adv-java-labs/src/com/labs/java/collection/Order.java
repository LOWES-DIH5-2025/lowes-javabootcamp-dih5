package com.labs.java.collection;

public class Order implements Cloneable {

    private int id;
    private String description;
    private String category;
    private int quantity;
    private double price;

    public Order() {
    }

    public Order(String description, String category, int quantity, double price) {
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public Order(int id, String description, String category, int quantity, double price) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
