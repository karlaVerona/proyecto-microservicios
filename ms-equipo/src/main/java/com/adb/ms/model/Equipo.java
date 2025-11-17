package com.adb.ms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipo") 
public class Equipo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEquipo")  
    private int id;
    
    @Column(name = "nombreEquipo", length = 20, unique = true, nullable = false)
    private String nombreEquipo;
    
    @Column(name = "idTorneo", nullable = false) 
    private int idTorneo;
    
    @Column(name = "listaIdJugadores", length = 1000)
    private String listaIdJugadores;
   
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombreEquipo() {
        return nombreEquipo;
    }
    
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    
    public int getIdTorneo() {
        return idTorneo;
    }
    
    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }
    
    public String getListaIdJugadores() {
        return listaIdJugadores;
    }
    
    public void setListaIdJugadores(String listaIdJugadores) {
        this.listaIdJugadores = listaIdJugadores;
    }
}