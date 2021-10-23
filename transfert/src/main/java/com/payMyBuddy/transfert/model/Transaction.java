package com.payMyBuddy.transfert.model;

import javax.persistence.*;
import java.util.Date;

public class Transaction {

    private long id;
    private Date date;
    private float amount;
    private String transmitter;
    private String receiver;

    public Transaction(long id, Date date, float amount, String transmitter, String receiver) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.transmitter = transmitter;
        this.receiver = receiver;
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

    public String getTransmitter() {
        return transmitter;
    }

    public void setTransmitter(String transmitter) {
        this.transmitter = transmitter;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", transmitter='" + transmitter + '\'' +
                ", receiver='" + receiver + '\'' +
                '}';
    }
}
