package com.utp.tmspaucars.dao;

import com.utp.tmspaucars.models.programacion.EstadoProgramacion;
import com.utp.tmspaucars.models.programacion.ProgramacionUnidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramacionUnidadDAO extends JpaRepository<ProgramacionUnidad, Integer> {
    List<ProgramacionUnidad> findByEstadoProgramacion(EstadoProgramacion estado);
}