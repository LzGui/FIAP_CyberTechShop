package br.com.fiap.cybertech.cybertech_shopcart.service;

import br.com.fiap.cybertech.cybertech_shopcart.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
   @Autowired
   private RestTemplate restTemplate;

   private final String userServiceUrl = "http://usuario-service/usuarios/";

   public User getUser(Long userId) {
      String url = userServiceUrl + userId;
      ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
      return response.getBody();
   }

}
