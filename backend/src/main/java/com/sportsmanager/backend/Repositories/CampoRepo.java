package com.sportsmanager.backend.Repositories;

import com.sportsmanager.backend.Entities.Campo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampoRepo extends JpaRepository<Campo,Long> {
}
