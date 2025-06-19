package com.labs.java.jdbc;

import com.labs.java.collection.OrderServiceTreeMapImpl;

import java.util.Collection;

public class OrderMain {
    public static void main(String[] args) {
        // TODO: Create an ArrayList of Order objects and perform various operations
        // such as adding and displaying orders.

        OrderService orderService = new OrderServiceImpl();


        // Create a list to hold orders
//        List<Order> orders = new ArrayList<>();

        Order order1 = new Order("Laptop", "Electronics", "PENDING",2, 1500.00);
        Order order2 = new Order("Smartphone", "Electronics", "APPROVED",5, 800.00);
        Order order3 = new Order("Headphones", "Accessories", "REJECTED",10, 100.00);

//        orders.add(order1);
//        orders.add(order2);
//        orders.add(order3);
//        order1.setPrice(2000.00); // Update price of order1
//        orders.remove(order3);

        // Create orders
        orderService.createOrder(order1);
        orderService.createOrder(order2);
        orderService.createOrder(order3);

        displayOrders(orderService.getAllOrders());

        Order updatedOrder1 = null;
        try {
            updatedOrder1 = (Order) order1.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Error while cloning the object");;
        }
        updatedOrder1.setDescription("Gaming Laptop");
        updatedOrder1.setPrice(2000.00);

        orderService.updateOrder(16,updatedOrder1);
        orderService.deleteOrder(15);

        displayOrders(orderService.getAllOrders());

    }

    private static void displayOrders(Collection<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        System.out.println("Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
