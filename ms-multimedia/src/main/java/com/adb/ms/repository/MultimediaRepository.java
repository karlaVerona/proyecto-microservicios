package com.adb.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adb.ms.model.Multimedia;

public interface MultimediaRepository extends JpaRepository<Multimedia, Integer> {
	
	@Query(value = "SELECT * FROM Multimedia WHERE idUsuario = :idUsuario", nativeQuery = true)
    List<Multimedia> buscarPorUsuario(@Param("idUsuario") int idUsuario);
	
}
