package br.com.fiap.cybertech.cybertech_shopcart.controller;

import br.com.fiap.cybertech.cybertech_shopcart.service.CartService;
import br.com.fiap.cybertech.cybertech_shopcart.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

   @Autowired
   private CartService cartService;

   @GetMapping("/{userId}")
   public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
      Cart cart = cartService.obterCarrinhoPorUsuario(userId);
      return ResponseEntity.ok(cart);
   }

   @PostMapping("/{userId}")
   public ResponseEntity<Cart> createOrUpdateCart(@PathVariable Long userId) {
      Cart cart = cartService.createOrUpdateCart(userId);
      return ResponseEntity.ok(cart);
   }
}

