package com.lesson.sweepstakes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/authenticated/**").authenticated()
                .and()
                .formLogin()
                .and()
                .logout().logoutSuccessUrl("/");
    }

@Bean
    public JdbcUserDetailsManager users (DataSource dataSource){

        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$12$9BN13RLFLyrg.P.xUxW2H.iosD59LqtciPAX4vGVN7a1nj3pT.CHe")
                .roles("USER")
                .build();

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        if( jdbcUserDetailsManager.userExists(user.getUsername()))
        {
            jdbcUserDetailsManager.deleteUser(user.getUsername());
        }
        jdbcUserDetailsManager.createUser(user);



        return jdbcUserDetailsManager;

    }

}
  /*@Bean
    public JdbcUserDetailsManager users(DataSource dataSource){
        UserDetails = User.builder()
        .username("user");
        .password("(bcrypt)$2a$12$8JjPBYDOsshi.hViMc1CkO/9wCvyo/OHwlP9e3b8YBkNwp18v6Unm")
                .build();

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        if( jdbcUserDetailsManager.userExists(user.getUsername()))
        {
            jdbcUserDetailsManager.deleteUser(user.getUsername());
        }

        jdbcUserDetailsManager.createUser(user);
        return null;*/
// jdbcauth
