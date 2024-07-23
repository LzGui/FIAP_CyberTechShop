package br.com.fiap.cybertech.cybertech_shopcart.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

   @Value("${jwt.secret}")
   private String secret;

   @Override
   public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
           throws IOException, ServletException {
      String token = request.getHeader("Authorization");

      if (token != null && token.startsWith("Bearer ")) {
         token = token.substring(7);
         Claims claims = Jwts.parser()
                 .setSigningKey(secret.getBytes())
                 .parseClaimsJws(token)
                 .getBody();

         String username = claims.getSubject();

         if (username != null) {
            // Aqui você pode carregar os detalhes do usuário e setar a autenticação
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(username, null, null));
         }
      }

      chain.doFilter(request, response);
   }
}
