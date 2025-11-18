package com.vinny.easy_finance.application.usuario;
import com.vinny.easy_finance.application.grupo.BuscarGrupoPorIdUseCase;
import com.vinny.easy_finance.controller.dto.usuario.CadastroUsuarioDto;
import com.vinny.easy_finance.controller.dto.usuario.UsuarioCadastradoDto;
import com.vinny.easy_finance.enums.Permissao;
import com.vinny.easy_finance.exception.UserAlreadyExistsException;
import com.vinny.easy_finance.infrastructure.repository.entity.UsuarioEntity;
import com.vinny.easy_finance.infrastructure.repository.jpa.UsuarioRepository;
import com.vinny.easy_finance.mapper.UsuarioMapper;
import com.vinny.easy_finance.domain.Usuario;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioUseCase {

    private final UsuarioRepository repository;
    private final BuscarGrupoPorIdUseCase buscarGrupoPorIdUseCase;
    private final UsuarioMapper mapper;

    @Transactional
    public UsuarioCadastradoDto executar(CadastroUsuarioDto dto) {

        if (repository.findByEmail(dto.email()) != null) throw new UserAlreadyExistsException("Este e-mail já está cadastrado.");

        Usuario usuario = Usuario.builder()
                .grupo(null)
                .nome(dto.nome())
                .email(dto.email())
                .senha(new BCryptPasswordEncoder().encode(dto.senha()))
                .compras(new ArrayList<>())
                .permissao(Permissao.USER)
                .build();
        UsuarioEntity entidade = mapper.from(usuario);

        repository.save(entidade);

        return mapper.from(entidade);
    }
}

