package com.example.demo.dao;

import com.example.demo.models.conductor.Conductor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ConductorRepository {
    private final List<Conductor> conductores = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public ConductorRepository() {
        // Datos de prueba iniciales
        guardar(new Conductor(null, "Carlos", "Mendoza", "12345678", "Q12345678", "A-IIIc", LocalDate.of(2028, 5, 20), "987654321", "ACTIVO"));
        guardar(new Conductor(null, "Juan", "Pérez", "87654321", "Q87654321", "A-IIb", LocalDate.of(2027, 8, 15), "912345678", "ACTIVO"));
    }

    public List<Conductor> obtenerTodos() {
        return new ArrayList<>(conductores);
    }

    public Optional<Conductor> obtenerPorId(Long id) {
        return conductores.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Conductor guardar(Conductor conductor) {
        if (conductor.getId() == null) {
            conductor.setId(idGenerator.getAndIncrement());
            conductores.add(conductor);
        } else {
            eliminarPorId(conductor.getId());
            conductores.add(conductor);
        }
        return conductor;
    }

    public boolean eliminarPorId(Long id) {
        return conductores.removeIf(c -> c.getId().equals(id));
    }
}
