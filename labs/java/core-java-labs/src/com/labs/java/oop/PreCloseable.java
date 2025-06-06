package com.labs.java.oop;

public interface PreCloseable {
    public static final double PENALTY_RATE = 0.5;
    public void preClose();

    public default void notification() {
        System.out.println("Account has been pre-closed");
        sendNotification();
    }

    private void sendNotification() {
        System.out.println("Sending Notification...");
    }
}
