package com.vinny.easy_finance.mapper;

import com.vinny.easy_finance.controller.dto.usuario.CadastroUsuarioDto;
import com.vinny.easy_finance.controller.dto.usuario.CadastroUsuarioGrupoDto;
import com.vinny.easy_finance.controller.dto.usuario.UsuarioCadastradoDto;
import com.vinny.easy_finance.model.Usuario;
import com.vinny.easy_finance.repository.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario from(CadastroUsuarioDto cadastroUsuarioDto);
    Usuario from(CadastroUsuarioGrupoDto cadastroUsuarioGrupoDto);
    UsuarioEntity from(Usuario usuario);
    UsuarioCadastradoDto from(UsuarioEntity usuarioEntity);
}
