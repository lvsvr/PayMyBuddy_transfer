package com.payMyBuddy.transfer.model;

import javax.persistence.*;
import java.util.Date;

public class Transaction {

    private long id;
    private Date date;
    private float amount;

    public Transaction() {
    }

    public Transaction(long id, Date date, float amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
