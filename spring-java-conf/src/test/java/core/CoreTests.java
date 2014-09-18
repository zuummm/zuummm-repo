package core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import core.Pub;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Pub.class)
public class CoreTests {

	@Test
	public void testPub() {
	    ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Pub pub = (Pub) context.getBean("pub");
        Event event = (Event) context.getBean("event");
        
        org.junit.Assert.assertEquals(event.getName(),pub.getEvent().getName());
	}

}
