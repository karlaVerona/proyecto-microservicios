package com.adb.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adb.ms.model.Deporte;

import com.adb.ms.repository.DeporteRepository;

@Service
public class DeporteService {

	@Autowired
	private DeporteRepository repo;

	public List<Deporte> mostrar() {
		return repo.findAll();
	}

	public Deporte guardar(Deporte dep) {
		return repo.save(dep);
	}

	public Optional<Deporte> buscarPorId(int id) {
		return repo.findById(id);
	}
	
	public List<Deporte> buscarPorNombre(String nombre) {
        return repo.buscarPorNombre(nombre);
    }
	
	public void eliminar(int id) {
        repo.deleteById(id);
    }

}
