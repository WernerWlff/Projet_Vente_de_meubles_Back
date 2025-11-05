package com.monEntreprise.meubles.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "furnitures")
public class Furniture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false )
    private String title;

    @ManyToOne
    @JsonBackReference("furniture-user")
    @JoinColumn(name = "type_id", nullable = false )
    private Type type;

    @Column(nullable = false )
    private String description;

    @Column(nullable = false )
    private double price;

    @ManyToOne
    @JsonBackReference("furniture-status")
    @JoinColumn(name = "status_id", nullable = false )
    private Status status;

    @Column(nullable = false )
    private Date created_at;

    @Column(nullable = false )
    private String photo;

    @ManyToOne
    @JsonBackReference("furniture-type")
    @JoinColumn(name = "vendor_id", nullable = false )
    private User user;

    @OneToMany(mappedBy = "furniture")
    @JsonManagedReference("transaction-furniture")
    private List<Transaction> transactions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
