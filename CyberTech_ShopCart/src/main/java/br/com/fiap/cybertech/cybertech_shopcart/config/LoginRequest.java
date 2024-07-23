package br.com.fiap.cybertech.cybertech_shopcart.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {
   private String username;
   private String password;
}
