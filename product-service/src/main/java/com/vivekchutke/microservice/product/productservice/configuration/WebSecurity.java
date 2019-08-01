package com.vivekchutke.microservice.product.productservice.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    Logger logger = LoggerFactory.getLogger(WebSecurity.class);

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/action/**")
//                .access("isFullyAuthenticated()")
//                .and()
//                .formLogin()
//                .and()
//                .csrf().disable();
//    }
//
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("************* In WebSecuritys configure method: "+http.toString());

        http.authorizeRequests().anyRequest().permitAll();
        // Added so we can refresh through http://<AppName>/actuator/refresh. Without this is was giving me forbidden exception.
        // The issue is still not resolved as now I am getting 404 exception
        http.csrf().disable();
    }

}
