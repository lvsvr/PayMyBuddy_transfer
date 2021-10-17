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
//    private long transmitterId;
//    private long receiverId;
    @Column(name="transaction_id")
    private long transactionId;
//    private Date date;
//    private float amount;
    @Column(name="deduction")
    private float deduction;

    public Invoice(long id, long transactionId, float deduction) {
        this.id = id;
        this.transactionId = transactionId;
        this.deduction = deduction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public float getDeduction() {
        return deduction;
    }

    public void setDeduction(float deduction) {
        this.deduction = deduction;
    }
}

