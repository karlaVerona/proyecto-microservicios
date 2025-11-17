package com.adb.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adb.ms.model.Historial;

public interface HistorialRepository extends JpaRepository<Historial, Integer>{
	@Query(value = "SELECT * FROM Historial WHERE idJugador = :idJugador", nativeQuery = true)
    Historial buscarPorJugador(@Param("idJugador") int idJugador);
}
