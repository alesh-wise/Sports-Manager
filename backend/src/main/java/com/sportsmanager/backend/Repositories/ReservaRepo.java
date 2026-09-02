package com.sportsmanager.backend.Repositories;


import com.sportsmanager.backend.Entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva,Long> {

    List<Reserva> findByUserId(Long id);

    List<Reserva> findByCampoIdAndDataReserva(Long campoId, LocalDate dataReserva);
}
