package com.adb.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adb.ms.model.Partido;
import com.adb.ms.repository.PartidoRepository;

@Service
public class PartidoService {

	@Autowired
	private PartidoRepository repo;

	public List<Partido> mostrar() {
		return repo.findAll();
	}

	public Partido guardar(Partido par) {
		return repo.save(par);
	}

	public Optional<Partido> buscarPorId(int id) {
		return repo.findById(id);
	}
	
	public List<Partido> buscarPorTorneo(int idTorneo) {
        return repo.buscarPorTorneo(idTorneo);
    }
	
	public List<Partido> buscarPorEquipo(int idEquipo){
		return repo.buscarPorEquipo(idEquipo);
	}
	
	public void eliminar(int id) {
        repo.deleteById(id);
    }
	
}
