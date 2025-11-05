package com.monEntreprise.meubles.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Date;
import java.util.List;

@Entity
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false )
    private String firstname;

    @Column(nullable = false )
    private String lastname;

    @NotBlank(message = "L'email ne peut pas être vide")
    @Pattern(
            regexp = "^(?=.{1,254}$)(?=.{1,64}@)[A-Za-z0-9_+&'-]+(\\.[A-zA-z0-9-]+)*@[^-][A-zA-z0-9-]+(\\.[A-zA-z0-9-]+)*(\\.[A-zA-z]{2,})$",
            message = "L'email n'est pas valide"
    )
    @Column(unique = true, nullable = false )
    private String email;

    @Column(nullable = false )
    private String password;

    @Column(nullable = false )
    private String role;

    @Column(nullable = false )
    private Date created_at;

    @Column(nullable = false )
    private Date updated_at;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference("furniture-user")
    private List<Furniture> furnitures;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference("transaction-user")
    private List<Transaction> transactions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
