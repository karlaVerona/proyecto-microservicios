package com.adb.ms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adb.ms.model.Equipo;
import com.adb.ms.service.EquipoService;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

	@Autowired
    private EquipoService equipoService;
	
	@GetMapping
	public List<Equipo> listar() {
		return equipoService.mostrar();
	}

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerEquipo(@PathVariable int id) {
        return equipoService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/jugadores")
    public Map<String, Object> obtenerEquipoConJugadores(@PathVariable int id) {
        return equipoService.obtenerEquipoConJugadores(id);
    }
    
    @PostMapping
	public Equipo crear(@RequestBody Equipo e) {
		return equipoService.guardar(e);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		equipoService.eliminar(id);
	}
	
}
