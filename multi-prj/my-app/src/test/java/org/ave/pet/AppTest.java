package org.ave.pet;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

    @Test
    public void testAppOwner() {
        // GIVEN
        App newApp = new App();
        
        // WHEN
        newApp.getOwner().feedPet();
        
        //THEN
        assertTrue(newApp.getOwner().hasCat());
        assertFalse(newApp.getPet().isHungry());
    }

}
