package br.com.fiap.cybertech_login.controller;

import br.com.fiap.cybertech_login.dto.AuthenticationDTO;
import br.com.fiap.cybertech_login.dto.LoginResponseDTO;
import br.com.fiap.cybertech_login.dto.RegisterDTO;
import br.com.fiap.cybertech_login.entity.User;
import br.com.fiap.cybertech_login.repository.UserRepository;
import br.com.fiap.cybertech_login.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

   @Autowired
   private AuthenticationManager authenticationManager;
   @Autowired
   private UserRepository repository;
   @Autowired
   private TokenService tokenService;

   @PostMapping("/login")
   public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
      var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
      var auth = this.authenticationManager.authenticate(usernamePassword);

      var token = tokenService.generateToken((User) auth.getPrincipal());

      return ResponseEntity.ok(new LoginResponseDTO(token));
   }

   @PostMapping("/register")
   public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
      if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

      String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
      User newUser = new User(data.login(), encryptedPassword, data.role());

      this.repository.save(newUser);

      return ResponseEntity.ok().build();
   }

}
