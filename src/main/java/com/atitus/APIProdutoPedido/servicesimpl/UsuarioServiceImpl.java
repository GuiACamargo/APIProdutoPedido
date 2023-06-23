package com.atitus.APIProdutoPedido.servicesimpl;

import com.atitus.APIProdutoPedido.entities.Usuario;
import com.atitus.APIProdutoPedido.repositories.GenericRepository;
import com.atitus.APIProdutoPedido.repositories.UsuarioRepository;
import com.atitus.APIProdutoPedido.services.UsuarioService;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        super();
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Optional<Usuario> usuarioOptional = this.usuarioRepository.findByEmail(email);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            return usuario;
        } else {
            throw new UsernameNotFoundException("Não existe usuário com o email: " + email);
        }
    }

    @Override
    public GenericRepository<Usuario> getRepository() {
        return usuarioRepository;
    }
}
