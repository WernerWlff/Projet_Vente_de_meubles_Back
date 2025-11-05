package com.monEntreprise.meubles.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false )
    private String types;

    @OneToMany(mappedBy = "type")
    @JsonManagedReference("furniture-type")
    private List<Furniture> furnitures;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }
}
