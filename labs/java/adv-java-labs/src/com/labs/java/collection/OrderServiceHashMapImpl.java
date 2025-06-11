package com.labs.java.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderServiceHashMapImpl implements OrderService {

    private Map<Integer, Order> orders = new HashMap<>();
    private static int idCounter = 1;
    @Override
    public int createOrder(Order order) {
        order.setId(idCounter++);
        orders.put(order.getId(), order);
        return order.getId();
    }

    @Override
    public Order getOrder(int id) {
        return orders.get(id);
    }

    @Override
    public boolean updateOrder(int id, Order updatedOrder) {
        return orders.replace(id, updatedOrder) != null;
    }

    @Override
    public boolean deleteOrder(int id) {
        return orders.remove(id) != null;
    }

    @Override
    public Collection<Order> getAllOrders() {
        return orders.values();
    }
}
