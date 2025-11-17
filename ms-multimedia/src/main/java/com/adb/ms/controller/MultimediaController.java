package com.adb.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adb.ms.model.Multimedia;
import com.adb.ms.service.MultimediaService;

@RestController
@RequestMapping("/multimedia")
@CrossOrigin(origins = "*")

public class MultimediaController {

	@Autowired
	private MultimediaService service;

	@GetMapping
	public List<Multimedia> listar() {
		return service.mostrar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Multimedia> buscarPorId(@PathVariable int id) {
		return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/idUsuario/{idUsuario}")
	public List<Multimedia> buscarPorNombre(@PathVariable int idUsuario) {
		return service.buscarPorUsuario(idUsuario);
	}

	@PostMapping
	public Multimedia crear(@RequestBody Multimedia m) {
		return service.guardar(m);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		service.eliminar(id);
	}
	
}
