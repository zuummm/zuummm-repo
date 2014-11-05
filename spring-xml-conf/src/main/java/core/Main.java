package core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Pub pub = (Pub) context.getBean("pubBean");

        context.registerShutdownHook();
        context.close();
        
        System.out.println("Welcome at " + pub.getName() + " on the following event: " + pub.getEvent().getName());
        System.out.println(pub.getMessage());
    }

}
