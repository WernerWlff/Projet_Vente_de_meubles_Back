package com.monEntreprise.meubles.repositories;

import com.monEntreprise.meubles.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
