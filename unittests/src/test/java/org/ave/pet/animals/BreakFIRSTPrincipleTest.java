package org.ave.pet.animals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.ave.pet.animals.broken.Owner;
import org.junit.Test;

public class BreakFIRSTPrincipleTest {

    private static Cat cat;
    private static Dog dog;

    @Test
    public void testFastTest() {
        // GIVEN
        // example: initialization takes a lot of time
        try {
            System.out.println(new Date());
            TimeUnit.SECONDS.sleep(3);
            System.out.println(new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Cat cat = new Cat();

        // WHEN - THEN
        assertNotNull(cat.getGender());
    }

    @Test
    public void testIndependentPreTest() {
        // GIVEN
        Owner owner = new Owner("Bela", "Bp, Parlament", dog, cat);
        
        // WHEN - THEN
        assertFalse(owner.hasDog());
    }

    @Test
    public void initTest() {
        // GIVEN
        dog = new Dog();
        Owner owner = new Owner("Bela", "Bp, Parlament", dog, cat);
        
        // WHEN - THEN
        assertNotNull(owner);
        assertTrue(owner.hasDog());
    }

    @Test
    public void testIndependentPostTest() {
        // GIVEN
        Owner owner = new Owner("Bela", "Bp, Parlament", dog, cat);
        
        // WHEN - THEN
        assertTrue(owner.hasDog());
    }

    @Test(expected = NullPointerException.class)
    public void testRepeatableTest() {
        // GIVEN
        Owner owner = new Owner("Bela", "Bp, Parlament", dog, cat);
        
        // WHEN
        owner.feedCat();
        
        // THEN
        assertNull(cat);
    }

    @Test
    public void testSelfValidatingTest() {
        // GIVEN
        Cat cat = new Cat();
        Dog dog = new Dog();
        Owner owner = new Owner("Bela", "Bp, Parlament", dog, cat);

        // WHEN
        owner.feedCat();
        owner.feedDog();

        // THEN
        // no assert validation or report to a log file.
    }

    @Test
    public void testTimelyTest() {
        // Nah ezt hogy tudnám igazolni.....?
        // Üres, így biztosan késve készül el, mert már van impl ....

    }

}
