package br.com.fiap.cybertech.cybertech_payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CyberTechPaymentApplication {

   public static void main(String[] args) {
      SpringApplication.run(CyberTechPaymentApplication.class, args);
   }

}
