package com.monEntreprise.meubles.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false )
    private String status;

    @OneToMany(mappedBy = "status")
    @JsonManagedReference("furniture-status")
    private List<Furniture> furnitures;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }


}
