package com.example.demo.models.conductor;

import java.time.LocalDate;

public class Conductor {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String numeroLicencia;
    private String categoriaLicencia;
    private LocalDate fechaVencimientoLicencia;
    private String telefono;
    private String estado; // EJEMPLO: "ACTIVO", "INACTIVO", "SUSPENDIDO"

    public Conductor() {
    }

    public Conductor(Long id, String nombre, String apellido, String dni, String numeroLicencia,
                     String categoriaLicencia, LocalDate fechaVencimientoLicencia, String telefono, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.numeroLicencia = numeroLicencia;
        this.categoriaLicencia = categoriaLicencia;
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
        this.telefono = telefono;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public String getCategoriaLicencia() {
        return categoriaLicencia;
    }

    public void setCategoriaLicencia(String categoriaLicencia) {
        this.categoriaLicencia = categoriaLicencia;
    }

    public LocalDate getFechaVencimientoLicencia() {
        return fechaVencimientoLicencia;
    }

    public void setFechaVencimientoLicencia(LocalDate fechaVencimientoLicencia) {
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
