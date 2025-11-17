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

import com.adb.ms.model.Deporte;
import com.adb.ms.service.DeporteService;

@RestController
@RequestMapping("/deportes")
@CrossOrigin(origins = "*")
public class DeporteController {
	
	@Autowired
	private DeporteService service;

	@GetMapping
	public List<Deporte> listar() {
		return service.mostrar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Deporte> buscarPorId(@PathVariable int id) {
		return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nombre/{nombre}")
	public List<Deporte> buscarPorNombre(@PathVariable String nombre) {
		return service.buscarPorNombre(nombre);
	}

	@PostMapping
	public Deporte crear(@RequestBody Deporte d) {
		return service.guardar(d);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		service.eliminar(id);
	}
}
