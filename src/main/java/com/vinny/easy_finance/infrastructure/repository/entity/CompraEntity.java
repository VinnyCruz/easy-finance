package com.vinny.easy_finance.infrastructure.repository.entity;

import com.vinny.easy_finance.enums.StatusCompra;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table(name = "compras")
@Entity
public class CompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private BigDecimal valor;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusCompra status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @OneToOne(mappedBy = "compra", fetch = FetchType.LAZY)
    private PagamentoEntity pagamento;
}