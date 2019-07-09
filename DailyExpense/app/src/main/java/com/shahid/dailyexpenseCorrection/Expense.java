package com.shahid.dailyexpenseCorrection;

public class Expense {
    private double amount;
    private int  date;
    private int time;
    private String expenseType;


    public Expense(double amount, int date, int time, String expenseType) {
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.expenseType = expenseType;

    }

    public double getAmount() {
        return amount;
    }

    public int getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    public String getExpenseType() {
        return expenseType;
    }


}
