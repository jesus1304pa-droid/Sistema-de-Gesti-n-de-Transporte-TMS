package com.example.demo.services;

import com.example.demo.dao.ConductorRepository;
import com.example.demo.models.conductor.Conductor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConductorService {

    private final ConductorRepository conductorRepository;
    // TODO: Inyecta el repositorio de viajes de tu equipo cuando lo tengan integrado
    // private final ViajeRepository viajeRepository;

    public ConductorService(ConductorRepository conductorRepository /*, ViajeRepository viajeRepository*/) {
        this.conductorRepository = conductorRepository;
        // this.viajeRepository = viajeRepository;
    }

    public List<Conductor> listarConductores() {
        return conductorRepository.findAll();
    }

    public Optional<Conductor> obtenerConductorPorId(Long id) {
        return conductorRepository.findById(id);
    }

    public Conductor registrarConductor(Conductor conductor) {
        if (conductor.getEstado() == null || conductor.getEstado().isEmpty()) {
            conductor.setEstado("ACTIVO");
        }
        return conductorRepository.save(conductor);
    }

    public Optional<Conductor> actualizarConductor(Long id, Conductor conductorDetalles) {
        return conductorRepository.findById(id).map(conductor -> {
            conductor.setNombre(conductorDetalles.getNombre());
            conductor.setApellido(conductorDetalles.getApellido());
            conductor.setDni(conductorDetalles.getDni());
            conductor.setNumeroLicencia(conductorDetalles.getNumeroLicencia());
            conductor.setCategoriaLicencia(conductorDetalles.getCategoriaLicencia());
            conductor.setFechaVencimientoLicencia(conductorDetalles.getFechaVencimientoLicencia());
            conductor.setTelefono(conductorDetalles.getTelefono());
            conductor.setEstado(conductorDetalles.getEstado());
            return conductorRepository.save(conductor);
        });
    }

    public boolean eliminarConductor(Long id) {
        if (!conductorRepository.existsById(id)) {
            return false;
        }

        conductorRepository.deleteById(id);
        return true;
    }
}