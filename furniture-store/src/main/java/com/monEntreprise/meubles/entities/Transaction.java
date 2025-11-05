package com.monEntreprise.meubles.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JsonBackReference("transaction-furniture")
    @JoinColumn(name = "furniture_id", nullable = false )
    private Furniture furniture;

    @ManyToOne
    @JsonBackReference("transaction-user")
    @JoinColumn(name = "user_id", nullable = false )
    private User user;

    @Column(nullable = false )
    private Date sold_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getSold_at() {
        return sold_at;
    }

    public void setSold_at(Date sold_at) {
        this.sold_at = sold_at;
    }
}
