package com.vinny.easy_finance.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter(AccessLevel.PACKAGE)
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Parcela {
    private UUID id;
    private BigDecimal valor;
    private Integer numero;
    private Pagamento pagamento;
}

