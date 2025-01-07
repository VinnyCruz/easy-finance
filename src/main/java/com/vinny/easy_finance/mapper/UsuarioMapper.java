package com.vinny.easy_finance.mapper;

import com.vinny.easy_finance.controller.dto.usuario.CadastroUsuarioDto;
import com.vinny.easy_finance.controller.dto.usuario.CadastroUsuarioGrupoDto;
import com.vinny.easy_finance.controller.dto.usuario.UsuarioCadastradoDto;
import com.vinny.easy_finance.model.Usuario;
import com.vinny.easy_finance.repository.entity.GrupoEntity;
import com.vinny.easy_finance.repository.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario from(CadastroUsuarioDto cadastroUsuarioDto);
    Usuario from(CadastroUsuarioGrupoDto cadastroUsuarioGrupoDto);
    UsuarioEntity from(Usuario usuario);

    default UsuarioCadastradoDto from(UsuarioEntity usuarioEntity) {
        return new UsuarioCadastradoDto(usuarioEntity.getGrupo().getGrupo(), usuarioEntity.getNome(), usuarioEntity.getEmail(), usuarioEntity.getPermissao());
    }
}

