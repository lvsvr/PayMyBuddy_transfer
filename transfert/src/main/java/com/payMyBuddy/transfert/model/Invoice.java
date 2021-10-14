package com.payMyBuddy.transfert.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    private long transmitterId;
    private long receiverId;
    @Column(name="transaction_id")
    private long transactionId;
    private Date date;
    private float amount;
    @Column(name="deduction")
    private float deduction;


    public Invoice(long id, long transmitterId, long receiverId, long transactionId, Date date, float amount, float deduction) {
        this.id = id;
        this.transmitterId = transmitterId;
        this.receiverId = receiverId;
        this.transactionId = transactionId;
        this.date = date;
        this.amount = amount;
        this.deduction = deduction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTransmitterId() {
        return transmitterId;
    }

    public void setTransmitterId(long transmitterId) {
        this.transmitterId = transmitterId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
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

    public float getDeduction() {
        return deduction;
    }

    public void setDeduction(float deduction) {
        this.deduction = deduction;
    }


}

