package br.com.fiap.cybertech.cybertech_shopcart.repository;

import br.com.fiap.cybertech.cybertech_shopcart.entity.ItemCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCartRepository extends JpaRepository<ItemCart, Long> {
}
