package org.ave.pet.animals;

import static org.junit.Assert.*;

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
		Owner owner = new Owner("Bela","Bp, Parlament", dog, cat);
		assertFalse(owner.hasDog());
	}
	
	@Test
	public void initTest() {
		dog = new Dog();
		Owner owner = new Owner("Bela","Bp, Parlament", dog, cat); 
		assertNotNull(owner);
		assertTrue(owner.hasDog());
	}
	
	@Test
	public void testIndependentPostTest() {
		Owner owner = new Owner("Bela","Bp, Parlament", dog, cat);
		assertTrue(owner.hasDog());
	}
	
	@Test(expected=NullPointerException.class)
	public void testRepeatableTest() {
		Owner owner = new Owner("Bela","Bp, Parlament", dog, cat); 
		owner.feedCat();
		assertNull(cat);
	}	
	
	@Test
	public void testSelfValidatingTest() {
		// GIVEN
		Cat cat = new Cat();
		Dog dog = new Dog();
		Owner owner = new Owner("Bela","Bp, Parlament", dog, cat);
		
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
