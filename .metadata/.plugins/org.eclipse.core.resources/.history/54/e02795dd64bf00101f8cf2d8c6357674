package com.adb.ms.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer id;
    
    @Column(name = "nombre", length = 75, nullable = false)
    private String nombre;
    
    @Column(name = "apellido", length = 75, nullable = false)
    private String apellido;
    
    @Column(name = "correo", length = 100, unique = true, nullable = false)
    private String correo;
    
    @Column(name = "contrasena", length = 20, nullable = false)
    private String contrasena;
    
    @Column(name = "idDeporte")
    private Integer idDeporte;
    
    @Column(name = "rol", length = 15)
    private String rol;
    
    @Column(name = "MultimediaJugador")
    private Boolean multimediaJugador;
    
    @Column(name = "fechaRegistro")
    private LocalDate fechaRegistro;

    // ========== GETTERS Y SETTERS ==========
    
    public Integer getIdUsuario() {
        return id;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.id = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getIdDeporte() {  // ← CORREGIDO: ahora dice getIdDeporte
        return idDeporte;
    }

    public void setIdDeporte(Integer idDeporte) {  // ← CORREGIDO
        this.idDeporte = idDeporte;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Boolean getMultimediaJugador() {
        return multimediaJugador;
    }

    public void setMultimediaJugador(Boolean multimediaJugador) {
        this.multimediaJugador = multimediaJugador;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}