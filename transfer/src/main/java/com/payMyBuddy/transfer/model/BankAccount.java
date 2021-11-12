package com.payMyBuddy.transfer.model;

import javax.persistence.*;

@Entity
@Table(name="bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "iban")
    private String iban;
    @OneToOne
    private UserAccount userAccount;

    public BankAccount() {
    }

    public BankAccount(long id, String iban, UserAccount userAccount) {
        this.id = id;
        this.iban = iban;
        this.userAccount = userAccount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
