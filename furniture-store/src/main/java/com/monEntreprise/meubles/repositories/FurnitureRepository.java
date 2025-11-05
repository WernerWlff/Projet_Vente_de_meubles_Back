package com.monEntreprise.meubles.repositories;

import com.monEntreprise.meubles.entities.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
}
