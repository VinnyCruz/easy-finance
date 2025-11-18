package com.vinny.easy_finance.application.grupo;

import com.vinny.easy_finance.controller.dto.grupo.CadastroGrupoDto;
import com.vinny.easy_finance.controller.dto.grupo.GrupoCadastradoDto;
import com.vinny.easy_finance.domain.Grupo;
import com.vinny.easy_finance.domain.Usuario;
import com.vinny.easy_finance.enums.Permissao;
import com.vinny.easy_finance.exception.UserNotFoundException;
import com.vinny.easy_finance.infrastructure.repository.entity.GrupoEntity;
import com.vinny.easy_finance.infrastructure.repository.entity.UsuarioEntity;
import com.vinny.easy_finance.infrastructure.repository.jpa.GrupoRepository;
import com.vinny.easy_finance.infrastructure.repository.jpa.UsuarioRepository;
import com.vinny.easy_finance.mapper.GrupoMapper;
import com.vinny.easy_finance.mapper.UsuarioMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastrarGrupoUseCase {
    private final GrupoRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final GrupoMapper mapper;
    private final UsuarioMapper usuarioMapper;


    @Transactional
    public GrupoCadastradoDto executar(UUID idUsuario, CadastroGrupoDto dto) {
        Grupo grupo = Grupo.builder()
                .grupo(dto.grupo())
                .usuarios(new ArrayList<>())
                .build();
        UsuarioEntity usuarioEntity = usuarioRepository.findById(idUsuario).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));
        Usuario usuario = usuarioMapper.fromEntity(usuarioEntity);
        usuario.setPermissao(Permissao.ADMIN);
        grupo.adicionarUsuario(usuarioMapper.fromEntity(usuarioEntity));
        GrupoEntity grupoSalvo = repository.save(mapper.from(grupo));
        usuarioRepository.save(usuarioMapper.from(usuario));
        return mapper.from(grupoSalvo);
    }
}
