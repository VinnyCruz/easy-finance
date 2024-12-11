package com.vinny.easy_finance.mapper;

import com.vinny.easy_finance.controller.dto.grupo.CadastroGrupoDto;
import com.vinny.easy_finance.controller.dto.grupo.GrupoCadastradoDto;
import com.vinny.easy_finance.model.Grupo;
import com.vinny.easy_finance.repository.entity.GrupoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GrupoMapper {
    Grupo from(CadastroGrupoDto cadastroGrupoDto);
    GrupoEntity from(Grupo grupo);
    GrupoCadastradoDto from(GrupoEntity grupoEntity);
}
