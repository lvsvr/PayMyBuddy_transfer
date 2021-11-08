package com.payMyBuddy.transfer.model;

import javax.persistence.*;

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
    private TransactionBuddy transaction;

    public Invoice(long id, float deduction, TransactionBuddy transaction) {
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

    public TransactionBuddy getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionBuddy transaction) {
        this.transaction = transaction;
    }
}

