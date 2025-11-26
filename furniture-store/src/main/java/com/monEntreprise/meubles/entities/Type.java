package com.monEntreprise.meubles.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false )
    private String type;

    @OneToMany(mappedBy = "type")
    @JsonManagedReference("furniture-type")
    private List<Furniture> furnitures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }
}
