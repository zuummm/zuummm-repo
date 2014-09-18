package core;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoreTest {

    @Test
    public void testPub() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Pub pub = (Pub) context.getBean("pubBean");
        Event event = (Event) context.getBean("eventBean");
        
        org.junit.Assert.assertEquals(event.getName(),pub.getEvent().getName());
    }

}
