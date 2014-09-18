package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Pub pub = (Pub) context.getBean("pubBean");

        System.out.println("Welcome at " + pub.getName() + " on the following event: " + pub.getEvent().getName());
        System.out.println(pub.getMessage());
    }

}
