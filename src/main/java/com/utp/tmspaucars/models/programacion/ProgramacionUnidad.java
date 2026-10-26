package com.utp.tmspaucars.models.programacion;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "programacion_unidades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramacionUnidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_viaje")
    private Integer codigoViaje;

    @Column(name = "ruc", nullable = false, length = 11)
    private String ruc;

    @Column(name = "fecha_programacion", nullable = false)
    private LocalDate fechaProgramacion;

    @Column(name = "tracto", nullable = false, length = 15)
    private String tracto;

    @Column(name = "acoplado", nullable = false, length = 15)
    private String acoplado;

    @Column(name = "id_conductor", nullable = false, length = 10)
    private String idConductor;

    @Column(name = "origen", nullable = false, length = 100)
    private String origen;

    @Column(name = "destino", nullable = false, length = 100)
    private String destino;

    @Column(name = "monto_flete", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoFlete;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "estado_programacion", nullable = false, length = 45)
    private EstadoProgramacion estadoProgramacion;

    @Builder.Default
    @Column(name = "incidencia", nullable = false, length = 500)
    private String incidencia = "";

    @Column(name = "fecha_registro", insertable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
}