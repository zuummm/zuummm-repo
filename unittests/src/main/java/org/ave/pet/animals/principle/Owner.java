package org.ave.pet.animals.principle;

import java.util.ArrayList;
import java.util.List;

import org.ave.pet.animals.Cat;
import org.ave.pet.animals.Dog;
import org.ave.pet.animals.Pet;

public class Owner {
	private String name;
	private String address;
	private List<? extends Pet> pets;
	
	public Owner() {		
	}
	
	public Owner(String newName, String newAddress, List<? extends Pet> pets) {
		this.name = newName;
		this.address = newAddress;
		this.pets = pets;
	}
	
	
	public void feedPet() {
		for (Pet pet: pets) {
			pet.eat();
		}
	}
	
	public List<Pet> getPetBySpecies(String species) {
		List<Pet> filteredResult = new ArrayList<Pet>();
		if (pets != null) {
			for (Pet pet : pets)
				if (pet instanceof Cat && "Cat".equalsIgnoreCase(species)) {
					filteredResult.add(pet);
				} else if (pet instanceof Dog && "Dog".equalsIgnoreCase(species)) {
					filteredResult.add(pet);
				}
		}
		return filteredResult;
	}
	
    public boolean hasCat() {
		return !getPetBySpecies("Cat").isEmpty();
	}
    
	public boolean hasDog() {
		return !getPetBySpecies("Dog").isEmpty();
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

}
