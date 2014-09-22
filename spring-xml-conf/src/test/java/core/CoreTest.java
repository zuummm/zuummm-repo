package core;

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
        assertAll(pub, event);
    }

    private void assertAll(Pub pub, Event event) {
        org.junit.Assert.assertEquals(event.getName(),pub.getEvent().getName());        
        org.junit.Assert.assertNotEquals(event,pub.getEvent());
    }

}
