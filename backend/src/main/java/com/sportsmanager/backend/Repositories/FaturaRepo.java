package com.sportsmanager.backend.Repositories;

import com.sportsmanager.backend.Entities.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturaRepo extends JpaRepository<Fatura,Long> {
}
