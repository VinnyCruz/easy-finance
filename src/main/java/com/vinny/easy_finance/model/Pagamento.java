package com.vinny.easy_finance.model;

import com.vinny.easy_finance.enums.FormaPagamento;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter(AccessLevel.PACKAGE)
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Pagamento {
    private UUID id;
    private FormaPagamento formaPagamento;
    private BigDecimal valorTotal;
    private Integer quantidadeParcelas;
    private Compra compra;
    private List<Parcela> parcelas;

    public boolean isParcelado() {
        return FormaPagamento.PARCELADO.equals(this.formaPagamento);
    }
}

