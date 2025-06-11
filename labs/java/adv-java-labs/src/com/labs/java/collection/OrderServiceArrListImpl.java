package com.labs.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderServiceArrListImpl implements OrderService {

    private List<Order> orders = new ArrayList<>();
    private static int idCounter = 1;

    @Override
    public int createOrder(Order order) {
        order.setId(idCounter++);
        orders.add(order);
        System.out.println("Order created successfully with ID: " + order.getId());
        return order.getId();
    }

    @Override
    public Order getOrder(int id) {
        for(Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    @Override
    public boolean updateOrder(int id, Order updatedOrder) {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getId() == id) {
                updatedOrder.setId(id); // Ensure the ID remains the same
                orders.set(i, updatedOrder);
                System.out.println("Order with ID " + id + " updated successfully.");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteOrder(int id) {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getId() == id) {
                orders.remove(i);
                System.out.println("Order with ID " + id + " deleted successfully.");
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<Order> getAllOrders() {
        return orders;
    }
}
