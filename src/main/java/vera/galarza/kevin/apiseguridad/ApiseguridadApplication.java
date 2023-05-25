package vera.galarza.kevin.apiseguridad;

import java.security.SecureRandom;
import java.util.Base64;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ApiseguridadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiseguridadApplication.class, args);
        SecureRandom secureRandom = new SecureRandom();
        byte[] keyBytes = new byte[32]; // 256 bits
        secureRandom.nextBytes(keyBytes);
        String base64Key = Base64.getEncoder().encodeToString(keyBytes);
        System.out.println("Generated Key: " + base64Key);
    }

//    @EnableWebSecurity
//    @Configuration
//    class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.csrf().disable()
//                    .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//                    .authorizeRequests()
//                    .antMatchers(HttpMethod.POST, "/user").permitAll()
//                    .anyRequest().authenticated();
//        }
//    }
}
