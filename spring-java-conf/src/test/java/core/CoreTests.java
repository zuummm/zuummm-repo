package core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfig.class)
public class CoreTests {

    @Test
    public void testPub() {
        // GIVEN
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Pub pub = (Pub) context.getBean(Pub.class);
        Event event = (Event) context.getBean(Event.class);

        // WHEN-THEN
        context.registerShutdownHook();
        assertAll(pub, event);        
    }

    private void assertAll(Pub pub, Event event) {
        org.junit.Assert.assertEquals(event.getName(),pub.getEvent().getName());        
        org.junit.Assert.assertNotEquals(event,pub.getEvent());
    }
}
