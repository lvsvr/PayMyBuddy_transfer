package com.payMyBuddy.transfert.model;

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
    @Column(name = "id")
    private long idUserAccount;

    public BankAccount(long id, String iban, long idUserAccount) {
        this.id = id;
        this.iban = iban;
        this.idUserAccount = idUserAccount;
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

    public long getIdUserAccount() {
        return idUserAccount;
    }

    public void setIdUserAccount(long idUserAccount) {
        this.idUserAccount = idUserAccount;
    }
}
