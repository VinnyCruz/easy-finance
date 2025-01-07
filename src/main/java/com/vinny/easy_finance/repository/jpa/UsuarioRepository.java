package com.vinny.easy_finance.repository.jpa;

import com.vinny.easy_finance.enums.Permissao;
import com.vinny.easy_finance.repository.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {
    UserDetails findByEmail(String email);
    UsuarioEntity findByGrupoId(UUID idGrupo);
}
