package com.payMyBuddy.transfer.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction_buddy")
public class TransactionBuddy extends Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "amount")
    private float amount;
    @Column(name = "description")
    private String description;
    @OneToOne
    @JoinColumn(name = "userBuddy_id")
    private UserBuddy userBuddy;

    public TransactionBuddy() {
    }

    public TransactionBuddy(long id, Date date, float amount, long id1, Date date1, float amount1, String description, UserBuddy userBuddy) {
        super(id, date, amount);
        this.id = id1;
        this.date = date1;
        this.amount = amount1;
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

    @Override
    public String toString() {
        return "TransactionBuddy{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", userBuddy=" + userBuddy +
                '}';
    }
}
