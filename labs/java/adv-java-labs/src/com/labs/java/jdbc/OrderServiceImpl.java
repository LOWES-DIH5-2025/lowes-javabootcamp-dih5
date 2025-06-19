package com.labs.java.jdbc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = null;

    public OrderServiceImpl() {
        orderDao = new OrderDaoJdbcImpl();
        // Initialize the service, could load initial data or configurations if needed
    }

    @Override
    public int createOrder(Order order) {
        int id = orderDao.createOrder(order);
        System.out.println("Order created successfully with ID: " + id);
        return id;
    }

    @Override
    public Order getOrder(int id) {
        return orderDao.getOrder(id);
    }

    @Override
    public boolean updateOrder(int id, Order updatedOrder) {
        return orderDao.updateOrder(id, updatedOrder);
    }

    @Override
    public boolean deleteOrder(int id) {
        return orderDao.deleteOrder(id);
    }

    @Override
    public Collection<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }
}
