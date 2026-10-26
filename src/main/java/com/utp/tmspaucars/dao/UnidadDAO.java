package com.utp.tmspaucars.dao;

import com.utp.tmspaucars.models.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadDAO extends JpaRepository<Unidad, String> { }