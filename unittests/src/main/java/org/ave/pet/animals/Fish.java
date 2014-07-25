package org.ave.pet.animals;


public class Fish extends Pet {

    private static final String NAMING_MALE = "male";
    private static final String NAMING_FEMALE = "female";
    private static final String NAMING_BABY = "baby";
    private static final String VOICE = "...";

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
