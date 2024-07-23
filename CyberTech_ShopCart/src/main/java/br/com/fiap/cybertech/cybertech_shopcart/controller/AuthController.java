package br.com.fiap.cybertech.cybertech_shopcart.controller;

import br.com.fiap.cybertech.cybertech_shopcart.config.LoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AuthController {

   @Value("${jwt.secret}")
   private String secret;

   @PostMapping("/login")
   public String login(@RequestBody LoginRequest loginRequest) {
      // Verifique as credenciais do usuário (esse é um exemplo simples)
      if (isValidUser(loginRequest)) {
         return Jwts.builder()
                 .setSubject(loginRequest.getUsername())
                 .setExpiration(new Date(System.currentTimeMillis() + 86400000))  // 24 horas
                 .signWith(SignatureAlgorithm.HS256, secret.getBytes())
                 .compact();
      }
      throw new RuntimeException("Credenciais inválidas");
   }

   private boolean isValidUser(LoginRequest loginRequest) {
      // Lógica de validação do usuário
      return true;  // Exemplo simplificado
   }
}
