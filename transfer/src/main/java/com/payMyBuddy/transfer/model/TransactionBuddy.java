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
    @OneToOne
    private UserBuddy userBuddy;

    public TransactionBuddy(long id, Date date, float amount, String transmitter, String receiver) {
        super(id, date, amount, transmitter, receiver);
    }

    public TransactionBuddy(long id, Date date, float amount, String transmitter, String receiver, long id1, Date date1, float amount1, boolean fromUser, UserBuddy userBuddy) {
        super(id, date, amount, transmitter, receiver);
        this.id = id1;
        this.date = date1;
        this.amount = amount1;
        this.fromUser = fromUser;
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

    public UserBuddy getUserBuddy() {
        return userBuddy;
    }

    public void setUserBuddy(UserBuddy userBuddy) {
        this.userBuddy = userBuddy;
    }
}
