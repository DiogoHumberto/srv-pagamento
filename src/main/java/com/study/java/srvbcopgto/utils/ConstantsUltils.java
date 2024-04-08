package com.study.java.srvbcopgto.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstantsUltils implements Serializable {

    public static final String RAABIT_FILA_PAGAMENTO_ENTREGA = "pagamento.entrega";

    public static final String RAABIT_EX_PAGAMENTO = "pagamentos.ex";
}
