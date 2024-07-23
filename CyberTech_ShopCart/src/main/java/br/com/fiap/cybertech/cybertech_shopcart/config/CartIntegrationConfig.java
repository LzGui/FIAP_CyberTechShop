package br.com.fiap.cybertech.cybertech_shopcart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.messaging.MessageHandler;

@Configuration
public class CartIntegrationConfig {

   @Bean
   public IntegrationFlow cartFlow() {
      return IntegrationFlows.from("cartChannel")
              .handle(httpOutboundGateway("http://localhost:8082/cart"))
              .get();
   }

   private MessageHandler httpOutboundGateway(String uri) {
      HttpRequestExecutingMessageHandler handler = new HttpRequestExecutingMessageHandler(uri);
      handler.setExpectedResponseType(String.class);
      return handler;
   }
}