package core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
/*@ComponentScan
@EnableAutoConfiguration*/
public class ApplicationConfig {
/*
*/
    @Bean(name="event")
    public Event event() {
       return new Event("Happy Hours");
    }

    @Bean(name="pub")
    @Scope("prototype")
    public Pub pub() {
       return new Pub();
    }
    
    /*
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class, args);
    }*/
}
