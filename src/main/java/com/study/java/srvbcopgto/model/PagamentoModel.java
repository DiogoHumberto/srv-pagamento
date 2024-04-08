package com.study.java.srvbcopgto.model;

import com.study.java.srvbcopgto.enums.StatusPgto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "pagamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "uuid")
public class PagamentoModel {

    @Id
    @GeneratedValue
    @Column(name = "uuid_pagamento")
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID uuid;

    private String numero;

    private BigDecimal valor;

    private String nome;

    private LocalDateTime dtExpiracao;

    private String codigo;

    @Enumerated(EnumType.STRING)
    private StatusPgto status;

    private Long tpPgtoId;

    private UUID pedidoUuid;

}
