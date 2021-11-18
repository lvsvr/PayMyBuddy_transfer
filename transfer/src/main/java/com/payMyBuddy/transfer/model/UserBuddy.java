package com.payMyBuddy.transfer.model;

import javax.persistence.*;

@Entity
@Table(name="user_buddy", indexes = {@Index( columnList = "userAccount_id, user_id", unique = true)})
public class UserBuddy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @OneToOne
    @JoinColumn(name = "userAccount_id")
    private UserAccount userAccount;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User buddy;

    public UserBuddy() {
    }

    public UserBuddy(UserAccount userAccount, User buddy) {
        this.userAccount = userAccount;
        this.buddy = buddy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public User getBuddy() {
        return buddy;
    }

    public void setBuddy(User buddy) {
        this.buddy = buddy;
    }

    @Override
    public String toString() {
        return "UserBuddy{" +
                "id=" + id +
                ", userAccount=" + userAccount +
                ", buddy=" + buddy +
                '}';
    }
}
