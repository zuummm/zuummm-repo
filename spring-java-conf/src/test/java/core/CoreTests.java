package core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfig.class)
public class CoreTests {

    @Test
    public void testPub() {
        // GIVEN
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class);
        context.refresh();
        
        Pub pub = context.getBean(Pub.class);
        Event event = context.getBean(Event.class);
        System.out.println("Viva " + pub.getEvent().getName());
        
        // WHEN-THEN
        context.registerShutdownHook();
        context.close();
        assertEquals(event.getName(),pub.getEvent().getName());
        assertNotEquals(event,pub.getEvent());
    }
}
