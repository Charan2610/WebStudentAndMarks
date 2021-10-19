package com.StudentMarkWeb.Config;

import com.StudentMarkWeb.Services.CustomUserDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {


    private CustomUserDetailsServices customUserDetailsServices;


    @Autowired
    public void setCustomUserDetailsServices(CustomUserDetailsServices customUserDetailsServices) {
        this.customUserDetailsServices = customUserDetailsServices;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
               .antMatchers("/").permitAll()
                .antMatchers("/students/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
               .loginPage("/")
               .loginProcessingUrl("/dologin")
              .defaultSuccessUrl("/students/");





    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication().withUser("charan").password(this.getPassEncoder().encode("1234")).roles("ADMIN");

        auth.userDetailsService(customUserDetailsServices).passwordEncoder(getPassEncoder());
    }

    @Bean
    public BCryptPasswordEncoder getPassEncoder(){

        return new BCryptPasswordEncoder();
    }




}
