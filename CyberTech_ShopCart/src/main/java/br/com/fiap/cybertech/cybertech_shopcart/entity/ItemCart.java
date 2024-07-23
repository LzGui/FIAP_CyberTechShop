package br.com.fiap.cybertech.cybertech_shopcart.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "item_cart")
@Data
public class ItemCart {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne
   @JoinColumn(name = "cart_id")
   private Cart cart;

   private String produto;
   private Integer quantidade;
   private BigDecimal preco;
}
