package core;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Event {

    private String name;

    public Event(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    
    @PostConstruct
    public void init() {
        System.out.println("Final count down ... init is ready.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Final count down ... Finito!");
    }

}
