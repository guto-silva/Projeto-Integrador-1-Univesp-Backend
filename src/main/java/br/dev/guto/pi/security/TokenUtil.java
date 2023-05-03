package br.dev.guto.pi.security;

import br.dev.guto.pi.model.Funcionario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.security.Key;
import java.util.Collections;
import java.util.Date;

public class TokenUtil {

    public static final long SEGUNDO = 1000;
    public static final long MINUTO = 60 * SEGUNDO;
    public static final long HORA = 60 * MINUTO;
    public static final long EXPIRATION = 8 * HORA;

    public static final String ISSUER = "#PI-Univesp#";
    public static final String SECRET_KEY = "0123456789012345678901234567890123";
    public static final String PREFIX = "Bearer ";

    public static FuncionarioToken encode(Funcionario funcionario) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        String jws = Jwts.builder().setSubject(funcionario.getNomeUsuario())
                                   .setIssuer(ISSUER)
                                   .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                                   .signWith(key, SignatureAlgorithm.HS256)
                                   .compact();

        return new FuncionarioToken(PREFIX + jws);
    }

    public static Authentication decode(HttpServletRequest request) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        token = token.replace(PREFIX, "");
        Jws<Claims> claims;
        claims = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(token);
        String subject = claims.getBody().getSubject();
        String issuer = claims.getBody().getIssuer();
        Date expiration = claims.getBody().getExpiration();

        if(isValid(subject, issuer, expiration)) {
            return new UsernamePasswordAuthenticationToken(subject, null, Collections.emptyList());
        }

        return null;
    }

    public static boolean isValid(String subject, String issuer, Date expiration) {
        return subject != null && subject.length() > 0 && issuer.equals(ISSUER) && expiration.after(new Date(System.currentTimeMillis()));
    }

}
