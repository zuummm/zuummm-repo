package org.ave.pet.animals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.ave.pet.animals.principle.Owner;
import org.junit.Before;
import org.junit.Test;

public class FollowFIRSTPrincipleTest {

	private Cat cat;
	private Dog dog;

	@Before
	public void setUp() throws Exception {
		cat = new Cat();
		dog = new Dog();
	}
	
	@Test
	public void testFastTest() {
		// GIVEN
		Owner owner = new Owner("Bela","Bp, Parlament", Arrays.asList(cat, dog));
		
		// WHEN 
		assertTrue(owner.hasDog());
	}
	
	@Test
	public void testIndependentPreTest() {
		// GIVEN
		Owner owner = createOwnerWithCatAndDog();
				
		// WHEN - THEN
		assertTrue(owner.hasCat());
	}
	
	@Test
	public void testIndependentPostTest() {
		// GIVEN
		Owner owner = createOwnerWithCatAndDog();
						
	    // WHEN  
		assertTrue(owner.hasCat());
	}
	
	@Test
	public void testRepeatableTest() {
		Cat cat = new Cat();
		Owner owner = createOwnerWithOnePet(cat);
		
		// WHEN
		owner.feedPet();
		
		// THEN
		assertFalse(cat.isHungry());
		
	}	
	
	@Test
	public void testSelfValidatingTest() {
		Dog dog = new Dog();		
		Owner owner = createOwnerWithOnePet(dog);
		
		// WHEN
		owner.feedPet();

		// THEN
		assertFalse(dog.isHungry());
	}
	
	

	@Test
	public void testTimelyTest() {
		// Nah ezt hogy tudnám igazolni.....? Elhiszed, hogy előbb készült?		
	}
	
	private Owner createOwnerWithCatAndDog() {
		Cat cat = new Cat();
		Dog dog = new Dog();
		return createOwnerWithCatAndDog(cat, dog);
	}
	
	private Owner createOwnerWithOnePet(Pet pet) {
		return new Owner("Bela", "Parlament", Arrays.asList(pet));
	}

	private Owner createOwnerWithCatAndDog(Cat cat, Dog dog) {
		return new Owner("Bela", "Parlament", Arrays.asList(cat, dog));
	}
	
}
