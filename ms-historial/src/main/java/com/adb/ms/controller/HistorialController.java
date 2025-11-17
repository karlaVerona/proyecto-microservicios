package com.adb.ms.controller;

import java.util.List;
import java.util.Optional;

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

import com.adb.ms.model.Historial;
import com.adb.ms.service.HistorialService;

@RestController
@RequestMapping("/historial")
@CrossOrigin(origins = "*")
public class HistorialController {
	
	@Autowired
	private HistorialService service;

	@GetMapping
	public List<Historial> listar() {
		return service.mostrar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Historial> buscarPorId(@PathVariable int id) {
		return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/idJugador/{idJugador}")
	public Optional<Historial> bucarPorJugador(@PathVariable int idJugador) {
		return service.buscarPorJugador(idJugador);
	}

	@PostMapping
	public Historial crear(@RequestBody Historial h) {
		return service.guardar(h);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		service.eliminar(id);
	}
	
}
