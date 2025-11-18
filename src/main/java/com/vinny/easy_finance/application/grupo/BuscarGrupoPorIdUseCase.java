package com.vinny.easy_finance.application.grupo;

import com.vinny.easy_finance.domain.Grupo;
import com.vinny.easy_finance.exception.GroupNotFoundException;
import com.vinny.easy_finance.infrastructure.repository.entity.GrupoEntity;
import com.vinny.easy_finance.infrastructure.repository.jpa.GrupoRepository;
import com.vinny.easy_finance.mapper.GrupoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarGrupoPorIdUseCase {
    private final GrupoRepository repository;
    private final GrupoMapper mapper;

    public Grupo buscarGrupoPorId(UUID grupoId) {
        GrupoEntity entidade = repository.findById(grupoId)
                .orElseThrow(() -> new GroupNotFoundException("Grupo não encontrado para o ID: " + grupoId));
        return mapper.fromEntity(entidade);
    }
}
