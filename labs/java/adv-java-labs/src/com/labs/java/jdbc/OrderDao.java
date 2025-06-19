package com.labs.java.jdbc;

import java.util.Collection;

public interface OrderDao {
    int createOrder(Order order);
    Order getOrder(int id);
    boolean updateOrder(int id, Order updatedOrder);
    boolean deleteOrder(int id);
    Collection<Order> getAllOrders();
}
