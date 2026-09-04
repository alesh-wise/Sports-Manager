package com.sportsmanager.backend.Repositories;

import com.sportsmanager.backend.Entities.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo  extends JpaRepository<Utilizador,Long> {

    Optional<Utilizador> findByEmail(String email);
}
