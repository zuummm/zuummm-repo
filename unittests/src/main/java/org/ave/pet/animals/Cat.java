package org.ave.pet.animals;

public class Cat extends Pet {

	public Cat() {
		super();
	}

	@Override
	public String getSexBySpecies() {
		return PetGender.MALE.equals(getGender()) ? "Tom" : "Queen";
	}

	@Override
	public String getBabyName() {
		return "Kitten";
	}

	@Override
	public String talk() {
		return "Meow";
	}

}
