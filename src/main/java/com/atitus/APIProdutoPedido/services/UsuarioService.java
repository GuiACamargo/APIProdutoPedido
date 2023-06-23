package com.atitus.APIProdutoPedido.services;

import com.atitus.APIProdutoPedido.entities.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends GenericService<Usuario>, UserDetailsService {

}
