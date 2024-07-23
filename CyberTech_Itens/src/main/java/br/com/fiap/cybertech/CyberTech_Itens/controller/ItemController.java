package br.com.fiap.cybertech.CyberTech_Itens.controller;

import br.com.fiap.cybertech.CyberTech_Itens.model.Item;
import br.com.fiap.cybertech.CyberTech_Itens.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

   @Autowired
   private ItemService itemService;

   @GetMapping
   public List<Item> getAllItens(){
      return itemService.findAll();
   }

   @GetMapping("/{id}")
   public ResponseEntity<Item> getItemById(@PathVariable Long id) {
      return itemService
              .findById(id)
              .map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());
   }

   @PostMapping
   public Item createItem(@RequestBody Item item){
      return itemService.save(item);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
      return itemService.findById(id)
              .map(item -> {
                 item.setName(itemDetails.getName());
                 item.setDescription(itemDetails.getDescription());
                 item.setPrice(itemDetails.getPrice());
                 item.setQuantity(itemDetails.getQuantity());
                 return ResponseEntity.ok(itemService.save(item));
              })
              .orElse(ResponseEntity.notFound().build());
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
      if (itemService.findById(id).isPresent()) {
         itemService.deleteById(id);
         return ResponseEntity.noContent().build();
      } else {
         return ResponseEntity.notFound().build();
      }
   }
}
