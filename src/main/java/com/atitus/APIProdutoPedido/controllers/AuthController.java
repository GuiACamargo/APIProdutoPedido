package com.atitus.APIProdutoPedido.controllers;

import com.atitus.APIProdutoPedido.config.JWTActions;
import com.atitus.APIProdutoPedido.controllers.DTO.LoginDTO;
import com.atitus.APIProdutoPedido.controllers.DTO.SignupDTO;
import com.atitus.APIProdutoPedido.entities.Usuario;
import com.atitus.APIProdutoPedido.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JWTActions jwtActions;

    private final UsuarioService usuarioService;

    public AuthController(AuthenticationManager authenticationManager, JWTActions jwtActions,
                          UsuarioService usuarioService) {
        super();
        this.authenticationManager = authenticationManager;
        this.jwtActions = jwtActions;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody SignupDTO signup) {
        Usuario usuarioNovo = new Usuario();
        usuarioNovo.setNome(signup.getNome());
        usuarioNovo.setEmail(signup.getEmail());
        String password = gerarSenhaAleatoria(10);
        usuarioNovo.setSenha(new BCryptPasswordEncoder().encode(password));

        try {
            usuarioService.save(usuarioNovo);
            return ResponseEntity.status(HttpStatus.OK).body(password);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getSenha()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String tokenJwt = jwtActions.generateTokenFromEmail(loginDTO.getEmail());
            return ResponseEntity.ok().body(tokenJwt);
        } catch (Exception e) {
            return ResponseEntity.status(403).body("Não foi possível logar! Confira os dados digitados, caso acredite ser um erro contate um administrador!");
        }
    }

    private String gerarSenhaAleatoria(int tamanho) {
        String CARACTERES_PERMITIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder(tamanho);

        for (int i = 0; i < tamanho; i++) {
            int indice = random.nextInt(CARACTERES_PERMITIDOS.length());
            senha.append(CARACTERES_PERMITIDOS.charAt(indice));
        }
        return senha.toString();
    }
}
