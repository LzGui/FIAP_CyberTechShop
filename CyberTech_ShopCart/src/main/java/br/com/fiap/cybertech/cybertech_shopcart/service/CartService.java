package br.com.fiap.cybertech.cybertech_shopcart.service;

import br.com.fiap.cybertech.cybertech_shopcart.entity.Cart;
import br.com.fiap.cybertech.cybertech_shopcart.entity.User;
import br.com.fiap.cybertech.cybertech_shopcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

   @Autowired
   private CartRepository cartRepository;

   @Autowired
   private UserService userService;

   public Cart obterCarrinhoPorUsuario(Long userId) {
      return cartRepository.findByUserId(userId)
              .orElseThrow(() -> new RuntimeException("Carrinho não encontrado para o usuário"));
   }

   public Cart createOrUpdateCart(Long userId) {
      Cart cart = cartRepository.findByUserId(userId)
              .orElse(new Cart());

      User user = userService.getUser(userId);
      cart.setUser(user);
      return cartRepository.save(cart);
   }
}
