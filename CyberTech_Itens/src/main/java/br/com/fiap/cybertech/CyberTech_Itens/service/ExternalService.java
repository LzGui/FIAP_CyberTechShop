package br.com.fiap.cybertech.CyberTech_Itens.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalService {
   @Autowired
   private RestTemplate restTemplate;

   public User getUser(Long userId) {
      return restTemplate.getForObject("http://user-service/api/users/" + userId, User.class);
   }
}}
