package br.com.fiap.cybertech.cybertech_shopcart.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
public class Cart {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @OneToOne
   @JoinColumn(name = "user_id")
   private User user;

   @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<ItemCart> itens = new ArrayList<>();
}