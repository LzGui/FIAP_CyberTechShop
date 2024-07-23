package br.com.fiap.cybertech.cybertech_shopcart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nome;
   private String email;
}
