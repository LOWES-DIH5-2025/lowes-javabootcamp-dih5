package com.labs.java.oop;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalUnit;

public class DepositAccount extends Account implements PreCloseable {

    private int tenure;
    private double principal;
    private LocalDate depositDate;

    public DepositAccount() {
    }

    public DepositAccount(int id, String name, String type, double roi, boolean isActive, int tenure, double principal, LocalDate depositDate) {
        super(id, name, type, roi, isActive);
        this.tenure = tenure;
        this.principal = principal;
        this.depositDate = depositDate;
    }

    public LocalDate getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(LocalDate depositDate) {
        this.depositDate = depositDate;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    @Override
    public void openAccount() {
        System.out.println("Deposit Account opened!!!");
    }

    @Override
    public double checkCurrentBalance() {

        Period period = Period.between(getDepositDate(), LocalDate.now());
        int noOfDays = period.getYears() * 365 + period.getMonths() * 30 + period.getDays();
        return principal + ( (principal * (getRoi() / 365) * noOfDays) / 100);
    }

    @Override
    public String toString() {
        return "DepositAccount{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", type=" + getType() +
                ", roi=" + getRoi() +
                ", isActive=" + isActive() +
                "tenure=" + getTenure() +
                ", principal=" + getPrincipal() +
                ", depositDate=" + getDepositDate() +
                '}';
    }

    @Override
    public void preClose() {
        System.out.println("Pre-closing Deposit Account...");
    }
}