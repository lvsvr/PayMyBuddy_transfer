package com.payMyBuddy.transfer.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="transaction_buddy")
public class TransactionBuddy extends Transaction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_id")
    private long id;
    @Column(name="date")
    private Date date;
    @Column(name="amount")
    private float amount;
    @Column(name="from_user")
    private boolean fromUser;
    @Column(name="description")
    private String description;
    @OneToOne
    private UserBuddy userBuddy;

    public TransactionBuddy() {
    }

    public TransactionBuddy(long id, Date date, float amount, boolean fromUser, String description, UserBuddy userBuddy) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.fromUser = fromUser;
        this.description = description;
        this.userBuddy = userBuddy;
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

    public boolean isFromUser() {
        return fromUser;
    }

    public void setFromUser(boolean fromUser) {
        this.fromUser = fromUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserBuddy getUserBuddy() {
        return userBuddy;
    }

    public void setUserBuddy(UserBuddy userBuddy) {
        this.userBuddy = userBuddy;
    }
}
