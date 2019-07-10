package com.shahid.dailyexpenseCorrection;

import java.sql.Date;
import java.sql.Time;

public class Expense {
    int id;
    private String amount;
    private String date;
    private String time;
    //private String expenseType;


    public Expense(int id, String amount, String date, String time) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
