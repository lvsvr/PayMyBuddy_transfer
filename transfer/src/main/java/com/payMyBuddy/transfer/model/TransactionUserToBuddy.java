package com.payMyBuddy.transfer.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="transaction_user_to_buddy")
public class TransactionUserToBuddy extends Transaction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_id")
    private long id;
    @Column(name="date")
    private Date date;
    @Column(name="amount")
    private float amount;
    @OneToOne
    private UserBuddy userBuddy;

    private String transmitter;

    private String receiver;

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

    public UserBuddy getUserBuddy() {
        return userBuddy;
    }

    public void setUserBuddy(UserBuddy userBuddy) {
        this.userBuddy = userBuddy;
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

    public TransactionUserToBuddy(long id, Date date, float amount, String transmitter, String receiver, long id1, Date date1, float amount1, UserBuddy userBuddy, String transmitter1, String receiver1) {
        super(id, date, amount, transmitter, receiver);
        this.id = id1;
        this.date = date1;
        this.amount = amount1;
        this.userBuddy = userBuddy;
        this.transmitter = "transmitter (user account): " + userBuddy.getUserAccount();
        this.receiver = "receiver: (buddy user account)" + userBuddy.getBuddy().getId();


    }
}
