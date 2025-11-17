package com.adb.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adb.ms.model.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
	@Query(value = "SELECT * FROM Equipo WHERE idEquipo = :id", nativeQuery = true)
	Equipo buscarPorId(@Param("id") int id);

	@Query(value = "SELECT * FROM Torneo WHERE idTorneo = :idTorneo", nativeQuery = true)
	List<Equipo> buscarPorTorneo(@Param("idTorneo") int idDeporte);
}
