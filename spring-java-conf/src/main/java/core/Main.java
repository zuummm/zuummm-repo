package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Pub pub = (Pub) context.getBean("pub");

        System.out.println("Welcome at " + pub.getName() + " on the following event: " + pub.getEvent().getName());
        System.out.println(pub.getMessage());
    }

}
