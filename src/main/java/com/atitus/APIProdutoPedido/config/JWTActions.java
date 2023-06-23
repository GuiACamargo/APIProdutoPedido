package com.atitus.APIProdutoPedido.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JWTActions {
    private final String secretJWT = "MimaFofinhoMeggyMimaFofinhoMeggyMimaFofinhoMeggy";

    // 1 Semana
    private final int jwtExpirationMs = 604800000;

    private Key key;

    public JWTActions() {
        byte[] decodedKey = Base64.getDecoder().decode(secretJWT);
        this.key = Keys.hmacShaKeyFor(decodedKey);
    }

    public String getEmailFromJwtToken(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validaJwtToken(String jwt) {
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parse(jwt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

    public String generateTokenFromEmail(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String getJwtFromRequest(HttpServletRequest request) {
		String jwt = request.getHeader("Authorization");
		if (jwt != null && !jwt.isEmpty()) {
			return jwt.substring(7);
		}
		return null;
	}
}
