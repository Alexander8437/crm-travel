 package com.ms.jwt.controller.jwtSecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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

import com.ms.jwt.config.AuthEntryPointJwt;
import com.ms.jwt.config.AuthTokenFilter;
import com.ms.jwt.config.AuthrEntryPointJwt;
import com.ms.jwt.service.UserDetailsServiceImpl;
 
 
 
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@ComponentScan(basePackages = {"com.jwt.services"})
public class WebSecurityConfig {

    @Autowired
   UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Autowired
    private AuthrEntryPointJwt unautharizedHandler;
    
    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	System.out.println("Helll");
    	 http.csrf(csrf -> csrf.disable())
         .exceptionHandling(exception -> exception
             .authenticationEntryPoint(unauthorizedHandler)
             .accessDeniedHandler(unautharizedHandler))
         .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
         .authorizeHttpRequests(auth ->
         auth.antMatchers("/Motherson/crm/v1/signup", "/Motherson/crm/v1/signin","/Motherson/crm/v1/mod","/Motherson/crm/v1/all").permitAll() // Exclude /signin and /login from authentication
         .antMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
        // .antMatchers("/Motherson/api/v1/**").authenticated()  // Require authentication for other /Motherson/api/v1/** endpoints
         
         );

        http.authenticationProvider(authenticationProvider());
    
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
}
