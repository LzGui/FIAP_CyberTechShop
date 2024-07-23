package br.com.fiap.cybertech.cybertech_payment.controller;

import br.com.fiap.cybertech.cybertech_payment.dto.PaymentDto;
import br.com.fiap.cybertech.cybertech_payment.service.PaymentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/payments")
public class PaymentController {

   @Autowired
   private PaymentService paymentService;

   @GetMapping
   public Page<PaymentDto> listAll(@PageableDefault(size = 10) Pageable pageable){
      return paymentService.getAll(pageable);
   }

   @GetMapping("/{id}")
   public ResponseEntity<PaymentDto> listPaymentById(@PathVariable @NotNull Long id) {
      PaymentDto paymentDto = paymentService.getById(id);

      return ResponseEntity.ok(paymentDto);
   }

   @PostMapping
   public ResponseEntity<PaymentDto> createPayment(@RequestBody @Valid PaymentDto paymentDto,
                                                   UriComponentsBuilder uriComponentsBuilder){

      PaymentDto payment = paymentService.createPayment(paymentDto);
      URI  endereco = uriComponentsBuilder
              .path("/payments/{id}")
              .buildAndExpand(payment.getId())
              .toUri();

      return ResponseEntity.created(endereco).body(payment);
   }

   @PutMapping("/{id}")
   public ResponseEntity<PaymentDto> updatePayment(@PathVariable @NotNull Long id,
                                                   @RequestBody @Valid PaymentDto paymentDto){

      PaymentDto updatedPayment = paymentService.updatePayment(id, paymentDto);

      return ResponseEntity.ok(updatedPayment);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<PaymentDto> deletePayment(Long id) {
      paymentService.deletePayment(id);

      return ResponseEntity.noContent().build();
   }
}
