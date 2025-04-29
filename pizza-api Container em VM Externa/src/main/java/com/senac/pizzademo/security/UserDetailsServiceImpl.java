package com.senac.pizzademo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {
    
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("admin")
                               .password("{noop}1234")       
                               .roles("USER")
                               .build();
        return new InMemoryUserDetailsManager(user);
    }
}
