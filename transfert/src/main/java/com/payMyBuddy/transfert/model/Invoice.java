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
    @Column(name="deduction")
    private float deduction;
    @OneToOne
    private TransactionUserToBuddy transaction;

    public Invoice(long id, float deduction, TransactionUserToBuddy transaction) {
        this.id = id;
        this.deduction = deduction;
        this.transaction = transaction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getDeduction() {
        return deduction;
    }

    public void setDeduction(float deduction) {
        this.deduction = deduction;
    }

    public TransactionUserToBuddy getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionUserToBuddy transaction) {
        this.transaction = transaction;
    }
}

