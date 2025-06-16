package com.labs.java.java8;

import com.labs.java.collection.OrderService;
import com.labs.java.collection.OrderServiceTreeMapImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class OrderMain {
    public static void main(String[] args) {
        // TODO: Create an ArrayList of Order objects and perform various operations
        // such as adding and displaying orders.

        // Create a list to hold orders
        List<Order> orders = new ArrayList<>();

        Order order1 = new Order(100, "Laptop", "Electronics", "PENDING", 2, 1500.00);
        Order order2 = new Order(101, "Smartphone", "Electronics", "APPROVED", 5, 800.00);
        Order order3 = new Order(102, "Headphones", "Accessories", "PENDING", 10, 10000.00);

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        // TODO:
//        a. Filter orders (e.g. find all pending or high-value orders) using Predicate<Order>
//
//        Collection<Order> filterOrders(Collection<Order> orders, Predicate<Order> condition)
//
        System.out.println("a. Filter orders using Predicate<Order>");

//        - Show count of Pending Orders
        Predicate<Order> pendingCondition = order -> "PENDING".equalsIgnoreCase(order.getStatus());
        Collection<Order> pendingOrders = filterOrders(orders, pendingCondition);
        System.out.println("Count of Pending Orders: " + pendingOrders.size());

//        - Show count of Expensive Orders (price > 5k)
        Predicate<Order> expensiveCondition = order -> order.getPrice() > 5000;
        Collection<Order> expensiveOrders = filterOrders(orders, expensiveCondition);
        System.out.println("Count of Expensive Orders: " + expensiveOrders.size());

//        b. Perform actions on orders (e.g. print details) using Consumer<Order>
//                - Print Order details
        System.out.println("b. Perform actions on orders using Consumer<Order>");
        Consumer<Order> printOrderIDs = order -> System.out.println("Order ID: " + order.getId());
        processOrders(orders, printOrderIDs);

        Consumer<Order> printOrderDetails = order ->
            System.out.println("Order ID: " + order.getId() + ", Description: " + order.getDescription() +
                               ", Category: " + order.getCategory() + ", Status: " + order.getStatus() + ", Price: " + order.getPrice());
        processOrders(orders, printOrderDetails);

//        c. Create custom labels for orders using Function<Order, String>
        System.out.println("c. Transform order description using Function<Order, Order>");
//        - Make Order Description to UpperCase
        Function<Order, Order> toUpperCaseDescription = order -> {
            order.setDescription(order.getDescription().toUpperCase());
            return order;
        };
        transformOrders(orders, toUpperCaseDescription);

        Function<Order, Order> discountPrice = order -> {
            order.setPrice(order.getPrice() * 0.85);
            return order;
        };
        transformOrders(orders, discountPrice);
//
//        d. Sort orders by price using Comparator<Order>
        System.out.println("d. Sort orders by price using Comparator<Order>");
//                - Sort Orders by price desc
        Comparator<Order> priceComparator = (o1,o2) -> o1.getPrice() > o2.getPrice() ? 1 : (o1.getPrice() < o2.getPrice() ? -1 : 0);
        sortOrders(orders, priceComparator);

    }

    private static Collection<Order> filterOrders(Collection<Order> orders, Predicate<Order> condition) {
        List<Order> filteredOrders = new ArrayList<>();
        for (Order order : orders) {
            if (condition.test(order)) {
                filteredOrders.add(order);
            }
        }
        return filteredOrders;
    }

    private static void processOrders(Collection<Order> orders, Consumer<Order> action) {
        for (Order order : orders) {
            action.accept(order);
        }
    }

    private static void transformOrders(Collection<Order> orders, Function<Order, Order> transformer) {
        for (Order order : orders) {
            Order tranformedOrder = transformer.apply(order);
            System.out.println("Transformed Order: " + tranformedOrder);
        }
    }

    private static void sortOrders(Collection<Order> orders, Comparator<Order> comparator) {
        List<Order> sortedOrders = new ArrayList<>(orders);
        sortedOrders.sort(comparator);
        System.out.println("Sorted Order: ");
        for (Order order : sortedOrders) {
            System.out.println(order);
        }
    }

}
