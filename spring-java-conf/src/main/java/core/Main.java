package core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
public class Main {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Pub pub = (Pub) context.getBean(Pub.class);
        pub.setName("Grund");
        pub.setMessage("Cheers!");
        System.out.println("Welcome at " + pub.getName() + " on the following event: " + pub.getEvent().getName());
        System.out.println(pub.getMessage());
        context.registerShutdownHook();
    }

}
