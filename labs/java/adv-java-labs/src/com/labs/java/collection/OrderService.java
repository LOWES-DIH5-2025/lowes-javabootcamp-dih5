package com.labs.java.collection;

import java.util.Collection;

public interface OrderService {
    int createOrder(Order order);
    Order getOrder(int id);
    boolean updateOrder(int id, Order updatedOrder);
    boolean deleteOrder(int id);
    Collection<Order> getAllOrders();
}
