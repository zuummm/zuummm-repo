package org.ave.pet.animals.broken;

import org.ave.pet.animals.Cat;
import org.ave.pet.animals.Dog;
import org.ave.pet.animals.Pet;


public class Owner {

	private String name;
	private String address;
	private Dog dog;
	private Cat cat;
	
	public Owner() {		
	}
	
	public Owner(String newName, String newAddress, Dog newDog, Cat newCat) {
		this.name = newName;
		this.address = newAddress;
		this.dog = newDog;
		this.cat = newCat;
	}
	
	public void feedDog() {	
	    dog.eat();
	}
	
	public void feedCat() {
		cat.eat();
	}
	
	public void feedPet(Pet pet) {
		if (pet instanceof Cat) {
			feedCat();
		} if (pet instanceof Dog) {
			feedDog();
		}
	}
	
    public boolean hasCat() {
		return cat != null;
	}
    
	public boolean hasDog() {
		return dog != null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}
	
	public void organizeMeeting() {
		// TODO: refactoring to Manager type person/party
	}
	
	public void doTheWasching() {
		// TODO: refactoring 
	}
	
	public void payBills() {
		// TODO: refactoring 
	}
	
	public void doQuoterlyPerformanceReview() {
		// TODO: refactoring 
	}
	
	public void evaluateQuoterlyPerformanceReview() {
		// TODO: refactoring 
	}
	
}
