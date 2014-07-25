package org.ave.pet.animals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class TalkingTest {

    private Cat cat;
    private Dog dog;

    @Before
    public void setUp() throws Exception {
        cat = new Cat();
        dog = new Dog();
    }

    @Test
    public void testPetGender() {
        assertNotNull(cat.getGender());
    }

    @Test
    public void testCatsNotUnderstandingDogs() {
        assertFalse(cat.getVoice().equalsIgnoreCase(dog.getVoice()));
    }
}
