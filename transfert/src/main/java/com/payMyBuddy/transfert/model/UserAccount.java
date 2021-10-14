package com.payMyBuddy.transfert.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long id;
    @Column(name="id_pmbUser")
    private long userId;
    private long bankAccount;
    @Column(name="balance")
    private double balance;
    private ArrayList<User> buddyList;
    private ArrayList<Transaction> history;
    private ArrayList<Invoice> invoiceList;

    public UserAccount(long id, long userId, long bankAccount, double balance, ArrayList<User> buddyList, ArrayList<Transaction> history, ArrayList<Invoice> invoiceList) {
        this.id = id;
        this.userId = userId;
        this.bankAccount = bankAccount;
        this.balance = balance;
        this.buddyList = buddyList;
        this.history = history;
        this.invoiceList = invoiceList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(long bankAccount) {
        this.bankAccount = bankAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<User> getBuddyList() {
        return buddyList;
    }

    public void setBuddyList(ArrayList<User> buddyList) {
        this.buddyList = buddyList;
    }

    public ArrayList<Transaction> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Transaction> history) {
        this.history = history;
    }

    public ArrayList<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(ArrayList<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }
}
