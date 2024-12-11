package com.vinny.easy_finance.repository.jpa;

import com.vinny.easy_finance.enums.Role;
import com.vinny.easy_finance.repository.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {
    boolean existsByRoleAndGrupoId(Role role, UUID grupo);

    UsuarioEntity findByEmail(@Param("email") String email);
}
