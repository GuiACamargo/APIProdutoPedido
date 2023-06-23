package com.atitus.APIProdutoPedido.repositories;

import com.atitus.APIProdutoPedido.entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario>{
    Optional<Usuario> findByEmail(String email);
}
