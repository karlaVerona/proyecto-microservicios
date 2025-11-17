package com.adb.ms.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.adb.ms.model.Equipo;
import com.adb.ms.repository.EquipoRepository;

@Service
public class EquipoService {

	@Autowired
	private EquipoRepository repo;

	@Autowired
	private RestTemplate restTemplate;

	public List<Equipo> mostrar() {
		return repo.findAll();
	}

	public Equipo guardar(Equipo equ) {
		return repo.save(equ);
	}

	public Optional<Equipo> buscarPorId(int id) {
		return repo.findById(id);
	}

	public List<Equipo> buscarPorTorneo(int idTorneo) {
		return repo.buscarPorTorneo(idTorneo);
	}

	public void eliminar(int id) {
		repo.deleteById(id);
	}

	public Map<String, Object> obtenerEquipoConJugadores(int idEquipo) {
		Equipo equipo = repo.buscarPorId(idEquipo);
		if (equipo == null) {
			return Map.of("error", "No se encontró el equipo con ID " + idEquipo);
		}

		String lista = equipo.getListaIdJugadores();
		if (lista == null || lista.isBlank()) {
			return Map.of("equipo", equipo, "jugadores", Collections.emptyList());
		}

		List<Integer> ids = Arrays.stream(lista.split(",")).map(String::trim).filter(s -> !s.isEmpty())
				.map(Integer::parseInt).collect(Collectors.toList());

		List<Object> jugadores = new ArrayList<>();

		for (int id : ids) {
			try {
				Object jugador = restTemplate.getForObject("http://localhost:8083/usuarios/" + id, Object.class);
				jugadores.add(jugador);
			} catch (Exception e) {
				jugadores.add(Map.of("idJugador", id, "error", "Jugador no encontrado o servicio no disponible"));
			}
		}

		Map<String, Object> resultado = new HashMap<>();
		resultado.put("equipo", equipo);
		resultado.put("jugadores", jugadores);
		return resultado;
	}

}
