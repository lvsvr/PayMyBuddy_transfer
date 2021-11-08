package com.payMyBuddy.transfer.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="transaction_bank")
public class TransactionBank extends Transaction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_id")
    private long id;
    @Column(name="date")
    private Date date;
    @Column(name="amount")
    private float amount;
    @Column(name="from_bank")
    private boolean fromBank;
    @OneToOne
    private BankAccount bankAccount;

    public TransactionBank(long id, Date date, float amount, String transmitter, String receiver) {
        super(id, date, amount, transmitter, receiver);
    }

    public TransactionBank(long id, Date date, float amount, String transmitter, String receiver, long id1, Date date1, float amount1, boolean fromBank, BankAccount bankAccount) {
        super(id, date, amount, transmitter, receiver);
        this.id = id1;
        this.date = date1;
        this.amount = amount1;
        this.fromBank = fromBank;
        this.bankAccount = bankAccount;
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

    public boolean isFromBank() {
        return fromBank;
    }

    public void setFromBank(boolean fromBank) {
        this.fromBank = fromBank;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "TransactionBank{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", fromBank=" + fromBank +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
