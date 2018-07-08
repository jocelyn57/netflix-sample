package lu.cgi.sample.netflix.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // https://stackoverflow.com/questions/48902706/spring-cloud-eureka-with-spring-security/
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll();



    }
}
