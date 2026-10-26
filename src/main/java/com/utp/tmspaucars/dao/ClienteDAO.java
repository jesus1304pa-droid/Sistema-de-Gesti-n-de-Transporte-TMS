package com.utp.tmspaucars.dao;

import com.utp.tmspaucars.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, String> { }