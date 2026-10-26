package com.utp.tmspaucars.services;

import com.utp.tmspaucars.dao.ConductorRepository;
import com.utp.tmspaucars.models.conductor.Conductor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConductorService {

    private final ConductorRepository conductorRepository;

    public ConductorService(ConductorRepository conductorRepository) {
        this.conductorRepository = conductorRepository;
    }

    public List<Conductor> listarConductores() {
        return conductorRepository.obtenerTodos();
    }

    public Optional<Conductor> obtenerConductorPorId(Long id) {
        return conductorRepository.obtenerPorId(id);
    }

    public Conductor registrarConductor(Conductor conductor) {
        if (conductor.getEstado() == null || conductor.getEstado().isEmpty()) {
            conductor.setEstado("ACTIVO");
        }
        return conductorRepository.guardar(conductor);
    }

    public Optional<Conductor> actualizarConductor(Long id, Conductor conductorDetalles) {
        return conductorRepository.obtenerPorId(id).map(conductor -> {
            conductor.setNombre(conductorDetalles.getNombre());
            conductor.setApellido(conductorDetalles.getApellido());
            conductor.setDni(conductorDetalles.getDni());
            conductor.setNumeroLicencia(conductorDetalles.getNumeroLicencia());
            conductor.setCategoriaLicencia(conductorDetalles.getCategoriaLicencia());
            conductor.setFechaVencimientoLicencia(conductorDetalles.getFechaVencimientoLicencia());
            conductor.setTelefono(conductorDetalles.getTelefono());
            conductor.setEstado(conductorDetalles.getEstado());
            return conductorRepository.guardar(conductor);
        });
    }

    public boolean eliminarConductor(Long id) {
        return conductorRepository.eliminarPorId(id);
    }
}