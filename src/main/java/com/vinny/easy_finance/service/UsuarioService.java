package com.vinny.easy_finance.service;

import com.vinny.easy_finance.controller.dto.usuario.CadastroUsuarioDto;
import com.vinny.easy_finance.controller.dto.usuario.UsuarioCadastradoDto;
import com.vinny.easy_finance.exception.UserAlreadyExistsException;
import com.vinny.easy_finance.mapper.UsuarioMapper;
import com.vinny.easy_finance.model.Grupo;
import com.vinny.easy_finance.model.Usuario;
import com.vinny.easy_finance.repository.entity.UsuarioEntity;
import com.vinny.easy_finance.repository.jpa.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {
    private final UsuarioRepository repository;
    private final GrupoService grupoService;
    private final UsuarioMapper mapper;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }

    @Transactional
    public UsuarioCadastradoDto cadastrarUsuario(UUID idGrupo, CadastroUsuarioDto cadastroUsuarioDto) {
        if (repository.findByEmail(cadastroUsuarioDto.email()) != null) throw new UserAlreadyExistsException("Este e-mail já está cadastrado em nosso sistema.");
        Grupo grupo = grupoService.buscarGrupoPorId(idGrupo);
        String senhaCriptografada = new BCryptPasswordEncoder().encode(cadastroUsuarioDto.senha());
        Usuario usuario = new Usuario(grupo, cadastroUsuarioDto.nome(), cadastroUsuarioDto.email(), senhaCriptografada, cadastroUsuarioDto.permissao());
        UsuarioEntity entidade = mapper.from(usuario);
        repository.save(entidade);
        return mapper.from(entidade);
    }
}
