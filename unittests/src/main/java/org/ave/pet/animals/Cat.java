package org.ave.pet.animals;


public class Cat extends Pet {

    private static final String NAMING_MALE = "Tom";
    private static final String NAMING_FEMALE = "Queen";
    private static final String NAMING_BABY = "Kitten";
    private static final String VOICE = "Meow";

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
