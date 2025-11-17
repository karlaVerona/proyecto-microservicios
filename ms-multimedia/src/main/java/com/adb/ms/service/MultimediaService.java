package com.adb.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adb.ms.model.Multimedia;
import com.adb.ms.repository.MultimediaRepository;

@Service
public class MultimediaService {

	@Autowired
	private MultimediaRepository repo;

	public List<Multimedia> mostrar() {
		return repo.findAll();
	}

	public Multimedia guardar(Multimedia mul) {
		return repo.save(mul);
	}

	public Optional<Multimedia> buscarPorId(int id) {
		return repo.findById(id);
	}

	public List<Multimedia> buscarPorUsuario(int idUsuario) {
		return repo.buscarPorUsuario(idUsuario);
	}

	public void eliminar(int id) {
		repo.deleteById(id);
	}

}
