package com.adb.fx.model;

import java.time.LocalDate;

public class Torneo {
    private int id;
    private int idDeporte;
    private String nombreYClasificacion;
    private String reglasTorneo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Torneo(int id, int idDeporte, String nombreYClasificacion, String reglasTorneo, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.idDeporte = idDeporte;
        this.nombreYClasificacion = nombreYClasificacion;
        this.reglasTorneo = reglasTorneo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getId() { return id; }
    public int getIdDeporte() { return idDeporte; }
    public String getNombreYClasificacion() { return nombreYClasificacion; }
    public String getReglasTorneo() { return reglasTorneo; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
}
