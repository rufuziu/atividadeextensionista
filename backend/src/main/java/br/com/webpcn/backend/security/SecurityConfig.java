package br.com.webpcn.backend.security;

import br.com.webpcn.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http)
          throws Exception {
    http.authorizeHttpRequests(configurer ->
            configurer
                    .requestMatchers
                            (HttpMethod.GET, "/api/test").hasRole("USER"));
    http.httpBasic(Customizer.withDefaults());
    http.csrf(csrf -> csrf.disable());
    return http.build();
  }
}
