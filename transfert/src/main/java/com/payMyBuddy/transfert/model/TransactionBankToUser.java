package com.payMyBuddy.transfert.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="transaction_bank_to_user")
public class TransactionBankToUser extends Transaction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_id")
    private long id;
    @Column(name="date")
    private Date date;
    @Column(name="amount")
    private float amount;
    @OneToOne
    private BankAccount bankAccount;

    private String transmitter;

    private String receiver;

    public TransactionBankToUser(long id, Date date, float amount, String transmitter, String receiver, long id1, Date date1, float amount1, BankAccount bankAccount, String transmitter1, String receiver1) {
        super(id, date, amount, transmitter, receiver);
        this.id = id1;
        this.date = date1;
        this.amount = amount1;
        this.bankAccount = bankAccount;
        this.transmitter = "transmitter: " + bankAccount.getIban();
        this.receiver = "receiver (user account): " + bankAccount.getUserAccount();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public float getAmount() {
        return amount;
    }

    @Override
    public void setAmount(float amount) {
        this.amount = amount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String getTransmitter() {
        return transmitter;
    }

    @Override
    public void setTransmitter(String transmitter) {
        this.transmitter = transmitter;
    }

    @Override
    public String getReceiver() {
        return receiver;
    }

    @Override
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
