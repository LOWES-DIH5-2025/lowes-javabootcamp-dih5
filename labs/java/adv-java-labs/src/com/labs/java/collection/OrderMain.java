package com.labs.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class OrderMain {
    public static void main(String[] args) {
        // TODO: Create an ArrayList of Order objects and perform various operations
        // such as adding and displaying orders.

//        OrderService orderService = new OrderServiceArrListImpl();
//        OrderService orderService = new OrderServiceHashMapImpl();
        OrderService orderService = new OrderServiceTreeMapImpl();


        // Create a list to hold orders
//        List<Order> orders = new ArrayList<>();

        Order order1 = new Order("Laptop", "Electronics", 2, 1500.00);
        Order order2 = new Order("Smartphone", "Electronics", 5, 800.00);
        Order order3 = new Order("Headphones", "Accessories", 10, 100.00);

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

        orderService.updateOrder(1,updatedOrder1);
        orderService.deleteOrder(3);

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
