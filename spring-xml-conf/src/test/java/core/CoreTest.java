package core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoreTest {

    @Test
    public void testPub() {
        // GIVEN
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Pub pub = (Pub) context.getBean("pubBean");
        Event event = (Event) context.getBean("eventBean");
        
        // WHEN-THEN
        context.registerShutdownHook();
        context.close();
        
        assertEquals(event.getName(),pub.getEvent().getName());
        assertNotEquals(event,pub.getEvent());
    }

}
