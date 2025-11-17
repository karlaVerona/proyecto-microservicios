package com.adb.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adb.ms.model.Partido;

public interface PartidoRepository  extends JpaRepository<Partido, Integer>{
	@Query(value = "SELECT * FROM Partido WHERE idTorneo = :idTorneo", nativeQuery = true)
    List<Partido> buscarPorTorneo(@Param("idTorneo") int idTorneo);

    @Query(value = "SELECT * FROM Partido WHERE idEquipoLocal = :idEquipo OR idEquipoVisitante = :idEquipo", nativeQuery = true)
    List<Partido> buscarPorEquipo(@Param("idEquipo") int idEquipo);
}
