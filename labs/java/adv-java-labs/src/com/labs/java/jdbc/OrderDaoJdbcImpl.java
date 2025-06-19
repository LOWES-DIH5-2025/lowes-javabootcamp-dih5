package com.labs.java.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderDaoJdbcImpl implements OrderDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/training";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";

    private static Connection conn = null;

    {
        if(conn == null) {
            try {
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("Connected to the database successfully.");
            } catch (SQLException e) {
                throw new RuntimeException("Failed to connect to the database", e);
            }
        }
    }

    public OrderDaoJdbcImpl() {
        // Initialize the DAO, could load initial data or configurations if needed
    }

    @Override
    public int createOrder(Order order) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO orders (description, category, status, quantity, price) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, order.getDescription());
            stmt.setString(2, order.getCategory());
            stmt.setString(3, order.getStatus());
            stmt.setInt(4, order.getQuantity());
            stmt.setDouble(5, order.getPrice());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Order created successfully.");
                return rowsAffected; // Assuming the ID is auto-generated
            }
        } catch (SQLException e) {
            System.err.println("Error creating order: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public Order getOrder(int id) {
        Order order = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM orders WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                order = new Order(
                    rs.getInt("id"),
                    rs.getString("description"),
                    rs.getString("category"),
                    rs.getString("status"),
                    rs.getInt("quantity"),
                    rs.getDouble("price")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving order: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
        return order;
    }

    @Override
    public boolean updateOrder(int id, Order updatedOrder) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("UPDATE orders SET description = ?, category = ?, status = ?, quantity = ?, price = ? WHERE id = ?");
            stmt.setString(1, updatedOrder.getDescription());
            stmt.setString(2, updatedOrder.getCategory());
            stmt.setString(3, updatedOrder.getStatus());
            stmt.setInt(4, updatedOrder.getQuantity());
            stmt.setDouble(5, updatedOrder.getPrice());
            stmt.setInt(6, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error updating order: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.err.println("Error closing statement: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean deleteOrder(int id) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM orders WHERE id = ?");
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting order: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.err.println("Error closing statement: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public Collection<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
    try {
        stmt = conn.prepareStatement("SELECT * FROM orders");
        rs = stmt.executeQuery();
        while (rs.next()) {
            Order order = new Order(
                rs.getInt("id"),
                rs.getString("description"),
                rs.getString("category"),
                rs.getString("status"),
                rs.getInt("quantity"),
                rs.getDouble("price")
            );
            orders.add(order);
        }
    } catch (SQLException e) {
        System.err.println("Error retrieving all orders: " + e.getMessage());
    }
    finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            System.err.println("Error closing resources: " + e.getMessage());
        }
    }
    return orders;
    }
}
