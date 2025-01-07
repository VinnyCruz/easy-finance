package com.vinny.easy_finance.service;

import com.vinny.easy_finance.controller.dto.grupo.CadastroGrupoDto;
import com.vinny.easy_finance.controller.dto.grupo.GrupoCadastradoDto;
import com.vinny.easy_finance.exception.GroupNotFoundException;
import com.vinny.easy_finance.mapper.GrupoMapper;
import com.vinny.easy_finance.model.Grupo;
import com.vinny.easy_finance.repository.entity.GrupoEntity;
import com.vinny.easy_finance.repository.jpa.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GrupoService {
    private final GrupoRepository repository;
    private final GrupoMapper mapper;

    public GrupoCadastradoDto cadastrarNovoGrupo(CadastroGrupoDto cadastroGrupoDto) {
        Grupo grupo = mapper.from(cadastroGrupoDto);
        GrupoEntity entidade = mapper.from(grupo);
        repository.save(entidade);
        return mapper.from(entidade);
    }

    public Grupo buscarGrupoPorId(UUID grupoId) {
        GrupoEntity entidade = repository.findById(grupoId)
                .orElseThrow(() -> new GroupNotFoundException("Grupo não encontrado para o ID: " + grupoId));
        return mapper.fromEntity(entidade);
    }
}
