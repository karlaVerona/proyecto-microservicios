package com.adb.ms.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Partido")
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPartido")
	private int id;

	@Column(name = "idEquipoLocal", nullable = false)
	private int idEquipoLocal;

	@Column(name = "idEquipoVisitante", nullable = false)
	private int idEquipoVisitante;

	@Column(name = "idTorneo", nullable = false)
	private int idTorneo;

	@Column(name = "marcadorLocal")
	private int marcadorLocal;

	@Column(name = "marcadorVisitante")
	private int marcadorVisitante;

	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "hora")
	private Time hora;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEquipoLocal() {
		return idEquipoLocal;
	}

	public void setIdEquipoLocal(int idEquipoLocal) {
		this.idEquipoLocal = idEquipoLocal;
	}

	public int getIdEquipoVisitante() {
		return idEquipoVisitante;
	}

	public void setIdEquipoVisitante(int idEquipoVisitante) {
		this.idEquipoVisitante = idEquipoVisitante;
	}

	public int getIdTorneo() {
		return idTorneo;
	}

	public void setIdTorneo(int idTorneo) {
		this.idTorneo = idTorneo;
	}

	public int getMarcadorLocal() {
		return marcadorLocal;
	}

	public void setMarcadorLocal(int marcadorLocal) {
		this.marcadorLocal = marcadorLocal;
	}

	public int getMarcadorVisitante() {
		return marcadorVisitante;
	}

	public void setMarcadorVisitante(int marcadorVisitante) {
		this.marcadorVisitante = marcadorVisitante;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

}
