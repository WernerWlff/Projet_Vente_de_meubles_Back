package com.monEntreprise.meubles.repositories;

import com.monEntreprise.meubles.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
