package br.com.fiap.cybertech.CyberTech_Itens.service;

import br.com.fiap.cybertech.CyberTech_Itens.model.Item;
import br.com.fiap.cybertech.CyberTech_Itens.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

   @Autowired
   private ItemRepository itemRepository;

   public List<Item> findAll(){
      return itemRepository.findAll();
   }

   public Optional<Item> findById(Long id){
      return itemRepository.findById(id);
   }

   public Item save(Item item) {
      return itemRepository.save(item);
   }

   public void deleteById(Long id){
      itemRepository.deleteById(id);
   }
}
