package com.vinny.easy_finance.repository.entity;

import com.vinny.easy_finance.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table(name = "usuarios")
@Entity
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private String email;

    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<CompraEntity> compras;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupo_id")
    private GrupoEntity grupo;

    @Enumerated(EnumType.STRING)
    private Role role;
}
