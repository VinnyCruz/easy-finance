package com.vinny.easy_finance.repository.entity;

import com.vinny.easy_finance.enums.FormaPagamento;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table(name = "pagamentos")
@Entity
public class PagamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    private BigDecimal valorTotal;

    private Integer quantidadeParcelas;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compra_id")
    private CompraEntity compra;

    @OneToMany(mappedBy = "pagamento", cascade = CascadeType.ALL)
    private List<ParcelaEntity> parcelas;
}

