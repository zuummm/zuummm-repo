package org.ave.pet.animals;

public class Dog extends Pet {

	public Dog() {
		super();
	}

	@Override
	public String getSexBySpecies() {
		return PetGender.MALE.equals(getGender()) ? "dog" : "bitch";
	}

	@Override
	public String getBabyName() {
		return "Puppy";
	}

	@Override
	public String talk() {
		return "Bark";
	}

}
