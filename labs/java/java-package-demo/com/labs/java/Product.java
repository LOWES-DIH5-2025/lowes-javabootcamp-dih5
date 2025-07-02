// create class Product with fields id, name, price, and quantity
package com.labs.java;

public class Product {
  private int id;
  private String name;
  private double price;
  private int quantity;

  public Product(int id, String name, double price, int quantity) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public static void main(String[] args) {
    Product product = new Product(1, "Laptop", 999.99, 10);
    System.out.println("Product ID: " + product.getId());
    System.out.println("Product Name: " + product.getName());
    System.out.println("Product Price: $" + product.getPrice());
    System.out.println("Product Quantity: " + product.getQuantity());
  }
}