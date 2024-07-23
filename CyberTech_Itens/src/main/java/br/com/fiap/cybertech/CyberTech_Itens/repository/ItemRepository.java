package br.com.fiap.cybertech.CyberTech_Itens.repository;

import br.com.fiap.cybertech.CyberTech_Itens.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
