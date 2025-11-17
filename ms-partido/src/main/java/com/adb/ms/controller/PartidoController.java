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

import com.adb.ms.model.Partido;
import com.adb.ms.service.PartidoService;

@RestController
@RequestMapping("/partidos")
@CrossOrigin(origins = "*")
public class PartidoController {

	@Autowired
	private PartidoService service;

	@GetMapping
	public List<Partido> listar() {
		return service.mostrar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Partido> buscarPorId(@PathVariable int id) {
		return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/idTorneo/{idTorneo}")
	public List<Partido> buscarPorTorneo(@PathVariable int idTorneo) {
		return service.buscarPorTorneo(idTorneo);
	}
	
	@GetMapping("/idEquipo/{idEquipo}")
	public List<Partido> buscarPorEquipo(@PathVariable int idEquipo){
		return service.buscarPorEquipo(idEquipo);
	}

	@PostMapping
	public Partido crear(@RequestBody Partido d) {
		return service.guardar(d);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		service.eliminar(id);
	}
	
}
