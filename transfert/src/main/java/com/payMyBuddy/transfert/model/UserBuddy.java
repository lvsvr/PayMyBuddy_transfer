package com.payMyBuddy.transfert.model;

import javax.persistence.*;

@Entity
@Table(name="user_buddy")
public class UserBuddy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name ="userAccount_id")
    private long idUserAccount;
    @Column(name ="buddy_pmbUser_id")
    private long idBuddy;

    public UserBuddy(long id, long idUserAccount, long idBuddy) {
        this.id = id;
        this.idUserAccount = idUserAccount;
        this.idBuddy = idBuddy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUserAccount() {
        return idUserAccount;
    }

    public void setIdUserAccount(long idUserAccount) {
        this.idUserAccount = idUserAccount;
    }

    public long getIdBuddy() {
        return idBuddy;
    }

    public void setIdBuddy(long idBuddy) {
        this.idBuddy = idBuddy;
    }
}
