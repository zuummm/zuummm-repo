package core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {

    @Bean
    @Scope("singleton")
    public Pub pub() {
        return new Pub();
    }
    
    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Scope("prototype")
    public Event event() {
        return new Event("Happy Hours");
    }
}
