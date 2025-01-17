package br.com.fiap.cybertech.cybertech_shopcart.config;


import br.com.fiap.cybertech.cybertech_shopcart.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http.csrf().disable()
              .authorizeRequests(authorizeRequests ->
                      authorizeRequests
                              .requestMatchers("/cart/**").authenticated()
                              .anyRequest().permitAll()
              )
              .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

      return http.build();
   }

   @Bean
   public JwtAuthenticationFilter jwtAuthenticationFilter() {
      return new JwtAuthenticationFilter();
   }
}

