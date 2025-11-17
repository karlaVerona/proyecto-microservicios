package com.adb.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adb.ms.model.Historial;
import com.adb.ms.repository.HistorialRepository;

@Service
public class HistorialService {

	@Autowired
	private HistorialRepository repo;

	public List<Historial> mostrar() {
		return repo.findAll();
	}

	public Historial guardar(Historial his) {
		return repo.save(his);
	}

	public Optional<Historial> buscarPorId(int id) {
		return repo.findById(id);
	}
	
	public Optional<Historial> buscarPorJugador(int idJugador) {
		return repo.findById(idJugador);
	}
	
	public void eliminar(int id) {
        repo.deleteById(id);
    }
	
}
