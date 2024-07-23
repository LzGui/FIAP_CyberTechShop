package br.com.fiap.cybertech.CyberTech_Itens.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.messaging.MessageHandler;

@Configuration
public class ItemIntegrationConfig {
   @Bean
   public IntegrationFlow itemFlow() {
      return IntegrationFlows.from("cartChannel")
              .handle(httpOutboundGateway("http://localhost:8081/itens"))
              .get();
   }

   private MessageHandler httpOutboundGateway(String uri) {
      HttpRequestExecutingMessageHandler handler = new HttpRequestExecutingMessageHandler(uri);
      handler.setExpectedResponseType(String.class);
      return handler;
   }
}
