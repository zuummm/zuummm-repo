package org.ave.pet.animals;

public class Dog extends Pet {

    private static final String NAMING_MALE = "Dog";
    private static final String NAMING_FEMALE = "Bitch";
    private static final String NAMING_BABY = "Puppy";
    private static final String VOICE = "Bark";    
    
    @Override
    public String getSexBySpecies() {
        return PetGender.MALE == getGender() ? NAMING_MALE : NAMING_FEMALE;
    }

    @Override
    public String getBabyName() {
        return NAMING_BABY;
    }

    @Override
    public String getVoice() {
        return VOICE;
    }

}
