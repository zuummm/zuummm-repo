package org.ave.pet;

import static org.junit.Assert.*;

import org.ave.pet.animals.Cat;
import org.junit.Test;

public class AppTest {

    @Test
    public void testAppOwner() {
        // GIVEN
        App newApp = new App();
        
        // WHEN
        newApp.getOwner().feedPet();
        
        //THEN
        assertTrue(newApp.getOwner().hasPet(Cat.class));
        assertFalse(newApp.getPet().isHungry());
    }

}
