package com.vinny.easy_finance.model;

import com.vinny.easy_finance.enums.StatusCompra;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter(AccessLevel.PACKAGE)
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Compra {
    private UUID id;
    private BigDecimal valor;
    private String descricao;
    private StatusCompra status;
    private Usuario usuario;
    private Pagamento pagamento;
}

