package com.payMyBuddy.transfert.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="transmitter_id")
    private long idTransmitter;
    @Column(name="userBuddy_id")
    private long idUserBuddy;
    @Column(name="bankAccount_id")
    private long idBankAccount;
    @Column(name="date")
    private Date date;
    @Column(name="amount")
    private float amount;

    public Transaction(long id, long idTransmitter, long idUserBuddy, long idBankAccount, Date date, float amount) {
        this.id = id;
        this.idTransmitter = idTransmitter;
        this.idUserBuddy = idUserBuddy;
        this.idBankAccount = idBankAccount;
        this.date = date;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdTransmitter() {
        return idTransmitter;
    }

    public void setIdTransmitter(long idTransmitter) {
        this.idTransmitter = idTransmitter;
    }

    public long getIdUserBuddy() {
        return idUserBuddy;
    }

    public void setIdUserBuddy(long idUserBuddy) {
        this.idUserBuddy = idUserBuddy;
    }

    public long getIdBankAccount() {
        return idBankAccount;
    }

    public void setIdBankAccount(long idBankAccount) {
        this.idBankAccount = idBankAccount;
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
}
