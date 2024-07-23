package br.com.fiap.cybertech.CyberTech_Itens.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   @Bean
   public UserDetailsService userDetailsService() {
      InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
      manager.createUser(User.withUsername("admin")
              .password("{noop}password")
              .roles("ADMIN").build());
      return manager;
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http
              .authorizeRequests()
              .antMatchers("/items/**").hasRole("ADMIN")
              .and()
              .formLogin();
   }
}
