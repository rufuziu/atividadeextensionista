package br.com.rufuziu.knowledgearea_and_subjects.security.config;

import br.com.rufuziu.knowledgearea_and_subjects.security.jwt.AuthTokenFilter;
import br.com.rufuziu.knowledgearea_and_subjects.security.jwt.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {
    private final JwtUtils jwtUtils;

    public SecurityConfig(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter(jwtUtils);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(auth ->
                        auth.requestMatchers("/v3/api-docs/**",
                                        "/configuration/ui",
                                        "/swagger-resources/**",
                                        "/configuration/security",
                                        "/swagger-ui/**",
                                        "/webjars/**",
                                        "/actuator/**")
                                .permitAll())
                .headers(h -> h.frameOptions(f -> f.sameOrigin()));

        http
//                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(
                                        "/api/v1/education-level/readAll",
                                        "/api/v1/knowledge-area/readAll",
                                        "/api/v1/knowledge-area/readByEducationLevel/**",
                                        "/api/v1/subject/readAll",
                                        "/api/v1/subject/readByKnowledgeArea/**"
                                )
                                .permitAll()
                                .anyRequest()
                                .authenticated());

        http.addFilterBefore(authenticationJwtTokenFilter(),
                UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
