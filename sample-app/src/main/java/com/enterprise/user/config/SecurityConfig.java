package com.enterprise.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${app.security.admin.username:workshop-admin}")
    private String adminUsername;
    
    @Value("${app.security.admin.password:SecureWorkshop2024!}")
    private String adminPassword;
    
    @Value("${app.security.user.username:workshop-user}")
    private String userUsername;
    
    @Value("${app.security.user.password:UserWorkshop2024!}")
    private String userPassword;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requiresChannel()
                .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
                .requiresSecure()
            .and()
            .csrf()
                .ignoringAntMatchers("/api/**") // Only disable CSRF for REST API endpoints
            .and()
            .authorizeRequests()
                .antMatchers("/api/public/**").permitAll()
                .antMatchers("/api/users/**").authenticated()
                .anyRequest().authenticated()
            .and()
            .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser(adminUsername)
            .password(passwordEncoder().encode(adminPassword))
            .roles("ADMIN")
            .and()
            .withUser(userUsername)
            .password(passwordEncoder().encode(userPassword))
            .roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}