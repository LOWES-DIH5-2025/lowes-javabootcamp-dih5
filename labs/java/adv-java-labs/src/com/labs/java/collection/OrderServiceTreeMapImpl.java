package com.labs.java.collection;

import java.util.*;

public class OrderServiceTreeMapImpl implements OrderService{

    private static Comparator<Integer> SORT_ORDER_ID_DESC = new Comparator<>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };

    private Map<Integer, Order> orders = new TreeMap<>(SORT_ORDER_ID_DESC);

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
