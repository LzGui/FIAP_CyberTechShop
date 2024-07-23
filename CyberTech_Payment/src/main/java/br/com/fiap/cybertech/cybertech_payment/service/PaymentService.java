package br.com.fiap.cybertech.cybertech_payment.service;

import br.com.fiap.cybertech.cybertech_payment.dto.PaymentDto;
import br.com.fiap.cybertech.cybertech_payment.model.Payment;
import br.com.fiap.cybertech.cybertech_payment.model.Status;
import br.com.fiap.cybertech.cybertech_payment.repository.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

   @Autowired
   private PaymentRepository paymentRepository;

   @Autowired
   private ModelMapper modelMapper;

   public Page<PaymentDto> getAll(Pageable pageable) {
      return paymentRepository
              .findAll(pageable)
              .map(p -> modelMapper.map(p, PaymentDto.class));
   }

   public PaymentDto getById(Long id) {
      Payment payment = paymentRepository.findById(id)
              .orElseThrow(() -> new EntityNotFoundException());

      return modelMapper.map(payment, PaymentDto.class);
   }

   public PaymentDto createPayment(PaymentDto paymentDto) {
      Payment payment = modelMapper.map(paymentDto, Payment.class);
      payment.setStatus(Status.CRIADO);
      paymentRepository.save(payment);

      return modelMapper.map(payment, PaymentDto.class);
   }

   public PaymentDto updatePayment(Long id, PaymentDto paymentDto) {
      Payment payment = modelMapper.map(paymentDto, Payment.class);
      payment.setId(id);
      payment = paymentRepository.save(payment);

      return modelMapper.map(payment, PaymentDto.class);
   }

   public void deletePayment(Long id){
      paymentRepository.deleteById(id);
   }

}
