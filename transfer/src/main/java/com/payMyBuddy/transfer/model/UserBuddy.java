package com.payMyBuddy.transfer.model;

import javax.persistence.*;

@Entity
@Table(name="user_buddy")
public class UserBuddy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @OneToOne
    private UserAccount userAccount;
    @OneToOne
    private User buddy;

    public UserBuddy() {
    }

    public UserBuddy(long id, UserAccount userAccount, User buddy) {
        this.id = id;
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
