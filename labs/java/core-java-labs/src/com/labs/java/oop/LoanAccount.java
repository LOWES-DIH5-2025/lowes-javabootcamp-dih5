package com.labs.java.oop;

import java.time.LocalDate;

public class LoanAccount extends Account implements PreCloseable {

    private int tenure;
    private double principal;
    private LoanType loanType; // HOME,CAR,GOLD
    private LocalDate startDate;

    public LoanAccount() {
    }

    public LoanAccount(int id, String name, String type, double roi, boolean isActive, int tenure, double principal, LoanType loanType, LocalDate startDate) {
        super(id, name, type, roi, isActive);
        this.tenure = tenure;
        this.principal = principal;
        this.loanType = loanType;
        this.startDate = startDate;
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

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public void openAccount() {
        super.setActive(true);
        System.out.println("Loan Account Opened Successfully!!!");
    }

    @Override
    public double checkCurrentBalance() {
        return getPrincipal();
        // TODO: Logic to compute the balance based on the repayment
    }

    public double computeEMI() {
        System.out.println("EMI Calculation goes here...");
        return 0.0;
    }

    @Override
    public String toString() {
        return "LoanAccount{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", type=" + getType() +
                ", roi=" + getRoi() +
                ", isActive=" + isActive() +
                ", tenure=" + tenure +
                ", principal=" + principal +
                ", loanType=" + loanType +
                ", startDate=" + startDate +
                '}';
    }

    @Override
    public void preClose() {
        System.out.println("Pre-closing Loan Account...");
    }
}
