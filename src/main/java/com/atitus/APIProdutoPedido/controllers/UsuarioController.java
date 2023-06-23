package com.atitus.APIProdutoPedido.controllers;

import com.atitus.APIProdutoPedido.entities.Usuario;
import com.atitus.APIProdutoPedido.services.GenericService;
import com.atitus.APIProdutoPedido.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/usuarios")
public class UsuarioController extends GenericController<Usuario> {

    final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        super();
        this.usuarioService = usuarioService;
    }

    @Override
    GenericService<Usuario> getService() {
        return usuarioService;
    }

    @Override
    ResponseEntity<Object> salvar(Usuario entidade) {
        entidade.setSenha(new BCryptPasswordEncoder().encode(entidade.getSenha()));
        try {
            getService().save(entidade);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(entidade);
    }
}
