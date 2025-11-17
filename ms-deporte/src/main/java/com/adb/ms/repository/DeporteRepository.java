package com.adb.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adb.ms.model.Deporte;

public interface DeporteRepository extends JpaRepository<Deporte, Integer> {
	@Query(value = "SELECT * FROM Deporte WHERE idDeporte = :id", nativeQuery = true)
	Deporte buscarPorId(@Param("id") int id);

	@Query(value = "SELECT * FROM Deporte WHERE nombreDeporte LIKE CONCAT('%', :nombre, '%')", nativeQuery = true)
	List<Deporte> buscarPorNombre(@Param("nombre") String nombre);
}
