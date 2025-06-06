package com.labs.java.oop;

/*
* Can't create instance for abstract class.
 */
public abstract class Account {

    private int id;
    private String name;
    private String type;
    private double roi;
    private boolean isActive;

    public Account() {
        System.out.println("Account default constructor...");
    }

    public Account(int id, String name, String type, double roi, boolean isActive) {
        System.out.println("Account parameterized constructor...");

        this.id = id;
        this.name = name;
        this.type = type;
        this.roi = roi;
        this.isActive = isActive;
    }

    public abstract void openAccount();
    public void closeAccount() {
        this.isActive = false;
        System.out.println("Account Closed!!!");
    }
    public abstract double checkCurrentBalance();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public static void printDetails() {
        System.out.println("Printing Account Details...");
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", roi=" + roi +
                ", isActive=" + isActive +
                '}';
    }
}
