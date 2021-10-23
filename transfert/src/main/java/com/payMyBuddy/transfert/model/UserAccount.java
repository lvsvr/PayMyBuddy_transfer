package com.payMyBuddy.transfert.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userAccount_id")
    private long id;
    @Column(name="balance")
    private double balance;
    @OneToOne
    private User user;
//    @OneToMany (cascade=CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
//    private ArrayList <User> buddyList;
//    @OneToMany
//    private ArrayList<Transaction> history;
//    @OneToMany
//    private ArrayList<Invoice> invoiceList;


    public UserAccount(long id, double balance, User user) {
        this.id = id;
        this.balance = balance;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
