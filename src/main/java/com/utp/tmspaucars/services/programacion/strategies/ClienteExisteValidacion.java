package com.utp.tmspaucars.models.programacion.strategies;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(1)
@RequiredArgsConstructor
public class ClienteExisteValidacion implements ValidacionProgramacion {

    private final ClienteDAO clienteDAO;

    @Override
    public void validar(ProgramacionRequestDTO dto) {
        if (!clienteDAO.existsById(dto.ruc())) {
            log.warn("Programación rechazada: cliente inexistente {}", dto.ruc());
            throw new ReglaNegocioException("El cliente con RUC " + dto.ruc() + " no existe");
        }
    }
}