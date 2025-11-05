package com.monEntreprise.meubles.repositories;

import com.monEntreprise.meubles.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
