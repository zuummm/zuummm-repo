package org.ave.pet.animals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.ave.pet.animals.broken.Owner;
import org.junit.Test;

/**
 * This class aims to brake the FIRST principles: <br>
 * FAST - a test should be fast <br>
 * INDEPENDENT -  when it runs it does not depends on any result of other test cases <br>
 * REPEATABLE - a test case results the same any time when it runs <br>
 * SELF-VALIDATING - test result should be verified at the end of the test case <br>
 * TIMELY - it should be written during development not after <br>
 * 
 * @author Andrea_Verebi
 */
public class BreakFIRSTPrincipleTest {

    /**
     * <b>'dog'</b> variable should help to present how the <b>INDEPENDENT principle</b> brakes. <br>
     *    
     */
    private static Cat cat;

    /**
     * <b>'dog'</b> variable should help to present how the <b>INDEPENDENT principle</b> brakes. <br>
     *  It is initialized when testIndependentInitTest test cases is running. <br>   
     */
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

    /**
     * This method is valid if runs BEFORE testIndependentInitTest(). <br>
     * It has the same given parameter and runs the same action as testIndependentPostTest() but resulting different value. <br>
     * <br>
     * <b>dog</b> variable should help to present how the <b>INDEPENDENT principle</b> brakes. 
     * It is initialized when testIndependentInitTest case is running. <br>   
     */
    @Test
    public void testIndependentPreTest() {
        // GIVEN
        Owner owner = new Owner("Bela", "Bp, Parlament", dog, cat);

        // WHEN - THEN
        assertFalse(owner.hasDog());
    }

    /**  
     * <b>dog</b> variable should help to present how the <b>INDEPENDENT principle</b> brakes. 
     * It is initialized when testIndependentInitTest case is running. <br>
     */
    @Test
    public void testIndepententInitTest() {
        // GIVEN
        dog = new Dog();
        Owner owner = new Owner("Bela", "Bp, Parlament", dog, cat);

        // WHEN - THEN
        assertNotNull(owner);
        assertTrue(owner.hasDog());
    }

    /**
     * This method is valid if runs AFTER testIndependentInitTest(). <br>
     * It has the same given parameter and runs the same action as testIndependentPreTest() but resulting different value. <br>
     * <br>
     * <b>dog</b> variable should help to present how the <b>INDEPENDENT principle</b> brakes. 
     * It is initialized when testIndependentInitTest case is running. <br>   
     */
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
        // still not implemented but code is almost done
    }

}
