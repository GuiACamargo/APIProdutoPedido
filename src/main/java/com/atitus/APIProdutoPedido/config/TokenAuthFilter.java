package com.atitus.APIProdutoPedido.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.atitus.APIProdutoPedido.entities.Usuario;
import com.atitus.APIProdutoPedido.services.UsuarioService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenAuthFilter extends OncePerRequestFilter {
    private final JWTActions jwtActions;
    private final UsuarioService usuarioService;

    public TokenAuthFilter(JWTActions jwtActions, UsuarioService usuarioService) {
        super();
        this.jwtActions = jwtActions;
        this.usuarioService = usuarioService;
    }

    @Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = jwtActions.getJwtFromRequest(request);
			if (jwt != null && jwtActions.validaJwtToken(jwt)) {
				String emailUsuario = jwtActions.getEmailFromJwtToken(jwt);
				Usuario usuario = (Usuario) usuarioService.loadUserByUsername(emailUsuario);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
				usuario, null, usuario.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {

		}

		filterChain.doFilter(request, response);
	}
}