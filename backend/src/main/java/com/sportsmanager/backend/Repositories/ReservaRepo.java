package com.sportsmanager.backend.Repositories;


import com.sportsmanager.backend.Entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva,Long> {

    List<Reserva> findByUserId(Long id);

    List<Reserva> findByCampoIdAndDataReserva(Long campoId, LocalDate dataReserva);

    @Query("""
            SELECT COUNT(r) > 0 FROM Reserva r
            WHERE r.campo.id = :campoId
              AND r.dataReserva = :dia
              AND r.horaInicio < :horaFim
              AND r.horaFim > :horaInicio
            """)
    boolean existeReservaSobreposicao(
            @Param("campoId") Long campoId,
            @Param("dia") LocalDate dia,
            @Param("horaInicio") LocalTime horaInicio,
            @Param("horaFim") LocalTime horaFim
    );
}
