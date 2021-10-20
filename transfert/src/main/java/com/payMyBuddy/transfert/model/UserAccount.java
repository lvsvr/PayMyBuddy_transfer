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
//    private long bankAccount;
    @Column(name="balance")
    private double balance;
//    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)

//    private ArrayList<User> buddyList;
//    private ArrayList<Transaction> history;
//    private ArrayList<Invoice> invoiceList;


    public UserAccount(long id, long userId, double balance) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
