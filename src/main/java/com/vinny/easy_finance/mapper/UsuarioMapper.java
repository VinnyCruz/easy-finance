package com.vinny.easy_finance.mapper;

import com.vinny.easy_finance.controller.dto.usuario.CadastroUsuarioDto;
import com.vinny.easy_finance.controller.dto.usuario.CadastroUsuarioGrupoDto;
import com.vinny.easy_finance.controller.dto.usuario.UsuarioCadastradoDto;
import com.vinny.easy_finance.domain.Usuario;
import com.vinny.easy_finance.infrastructure.repository.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario from(CadastroUsuarioDto cadastroUsuarioDto);
    Usuario from(CadastroUsuarioGrupoDto cadastroUsuarioGrupoDto);
    UsuarioEntity from(Usuario usuario);
    Usuario fromEntity(UsuarioEntity usuarioEntity);

    default UsuarioCadastradoDto from(UsuarioEntity usuarioEntity) {
        return new UsuarioCadastradoDto(usuarioEntity.getNome(), usuarioEntity.getEmail(), usuarioEntity.getPermissao());
    }
}

