package com.monEntreprise.meubles.repositories;

import com.monEntreprise.meubles.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
