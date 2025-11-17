package com.adb.ms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Historial")
public class Historial {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHistorial")
    private int id;

    @Column(name = "idJugador", nullable = false)
    private int idJugador;

    @Column(name = "puntos")
    private int puntos;

    @Column(name = "sanciones", length = 500)
    private String sanciones;

	@Column(name = "asistencias")
    private int asistencias;

    @Column(name = "partidos_Jugados")
    private int partidosJugados;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getSanciones() {
		return sanciones;
	}

	public void setSanciones(String sanciones) {
		this.sanciones = sanciones;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public int getPartidosJugados() {
		return partidosJugados;
	}

	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}
	
}
