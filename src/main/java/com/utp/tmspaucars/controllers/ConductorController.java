package com.utp.tmspaucars.controllers;

import com.utp.tmspaucars.models.conductor.Conductor;
import com.utp.tmspaucars.services.ConductorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    private final ConductorService conductorService;

    public ConductorController(ConductorService conductorService) {
        this.conductorService = conductorService;
    }

    @GetMapping
    public List<Conductor> listar() {
        return conductorService.listarConductores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conductor> obtenerPorId(@PathVariable Long id) {
        return conductorService.obtenerConductorPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Conductor> crear(@RequestBody Conductor conductor) {
        Conductor nuevoConductor = conductorService.registrarConductor(conductor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoConductor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conductor> actualizar(@PathVariable Long id, @RequestBody Conductor conductor) {
        return conductorService.actualizarConductor(id, conductor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (conductorService.eliminarConductor(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
