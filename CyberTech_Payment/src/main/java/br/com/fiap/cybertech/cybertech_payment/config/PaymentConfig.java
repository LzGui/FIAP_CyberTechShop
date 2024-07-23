package br.com.fiap.cybertech.cybertech_payment.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

   @Bean
   public ModelMapper getModelMapper(){
      return new ModelMapper();
   }
}
