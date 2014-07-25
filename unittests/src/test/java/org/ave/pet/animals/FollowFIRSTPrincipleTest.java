package org.ave.pet.animals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.ave.pet.animals.principle.Owner;
import org.junit.Before;
import org.junit.Test;

/**
 * This class aims to follow and present the FIRST principles: <br>
 * FAST - a test should be fast <br>
 * INDEPENDENT -  when it runs it does not depends on any result of other test cases <br>
 * REPEATABLE - a test case results the same anytime when it runs <br>
 * SELF-VALIDATING - test result should be verified at the end of the test case <br>
 * TIMELY - it should be written during development not after <br>
 * 
 * @author Andrea_Verebi
 */
public class FollowFIRSTPrincipleTest {

    private Pet cat;
    private Pet dog;

    @Before
    public void setUp() throws Exception {
        cat = new Cat();
        dog = new Dog();
    }

    @Test
    public void testFastTest() {
        // GIVEN
        Owner owner = new Owner("Bela", "Parlament", Arrays.asList(cat, dog));

        // WHEN - THEN
        assertTrue(owner.hasPet(Dog.class));
    }

    @Test
    public void testIndependentPreTest() {
        // GIVEN
        Owner owner = createOwnerWithCatAndDog();

        // WHEN - THEN
        assertTrue(owner.hasPet(Cat.class));
    }

    @Test
    public void testIndependentPostTest() {
        // GIVEN
        Owner owner = createOwnerWithCatAndDog();

        // WHEN - THEN
        assertTrue(owner.hasPet(Cat.class));
    }

    @Test
    public void testRepeatableTest() {
        Pet cat = new Cat();
        Owner owner = createOwnerWithPet(cat);

        // WHEN
        owner.feedPet();

        // THEN
        assertFalse(cat.isHungry());

    }

    @Test
    public void testSelfValidatingTest() {
        Pet fish = new Fish();
        Owner owner = createOwnerWithPet(fish);

        // WHEN
        owner.feedPet();

        // THEN
        assertFalse(fish.isHungry());
    }

    @Test
    public void testTimelyTest() {
        // You should trust me. This and all of the other test cases were written during the development.
        Pet fish = new Fish();
        Owner owner = createOwnerWithPet(fish);

        // WHEN
        owner.feedPet();

        // THEN
        assertFalse(fish.isHungry());
    }

    private Owner createOwnerWithCatAndDog() {
        Cat cat = new Cat();
        Dog dog = new Dog();
        return createOwnerWithCatAndDog(cat, dog);
    }

    private Owner createOwnerWithPet(Pet... pet) {
        return new Owner("Bela", "Parlament", Arrays.asList(pet));
    }

    private Owner createOwnerWithCatAndDog(Cat cat, Dog dog) {
        return new Owner("Bela", "Parlament", Arrays.asList(cat, dog));
    }

}
