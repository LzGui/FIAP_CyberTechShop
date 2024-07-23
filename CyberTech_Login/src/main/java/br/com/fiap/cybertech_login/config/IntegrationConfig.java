package br.com.fiap.cybertech_login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.messaging.MessageHandler;

@Configuration
public class IntegrationConfig {

   @Bean
   public IntegrationFlow loginFlow() {
      return IntegrationFlows.from("loginChannel")
              .handle(httpOutboundGateway("http://localhost:8081/itens/{itemId}")
                      .httpMethod(HttpMethod.GET))
              .handle(httpOutboundGateway("http://localhost:8082/cart")
                      .httpMethod(HttpMethod.POST))
              .handle(httpOutboundGateway("http://localhost:8083/payments")
                      .httpMethod(HttpMethod.POST))
              .get();
   }

   private MessageHandler httpOutboundGateway(String uri) {
      HttpRequestExecutingMessageHandler handler = new HttpRequestExecutingMessageHandler(uri);
      handler.setExpectedResponseType(String.class);
      return handler;
   }
}
