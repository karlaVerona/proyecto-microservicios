package com.adb.ms.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Torneo")
public class Torneo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTorneo")
    private int id;

    @Column(name = "idDeporte")
    private int idDeporte;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(int idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getNombreYClasificacion() {
		return nombreYClasificacion;
	}

	public void setNombreYClasificacion(String nombreYClasificacion) {
		this.nombreYClasificacion = nombreYClasificacion;
	}

	public String getReglasTorneo() {
		return reglasTorneo;
	}

	public void setReglasTorneo(String reglasTorneo) {
		this.reglasTorneo = reglasTorneo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Column(name = "nombreYClasificacion", length = 50, nullable = false)
    private String nombreYClasificacion;

    @Column(name = "reglasTorneo", length = 1000)
    private String reglasTorneo;

    @Column(name = "fechaInicio")
    private LocalDate fechaInicio;

    @Column(name = "fechaFin")
    private LocalDate fechaFin;
}
