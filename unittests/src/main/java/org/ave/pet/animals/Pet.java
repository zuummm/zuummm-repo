package org.ave.pet.animals;

import java.awt.peer.SystemTrayPeer;

public abstract class Pet {

    public enum PetGender {
        MALE, FEMALE;
    }
    
    private String name;
    private PetGender gender;
    private Integer age;
    private Long microchip;
    private Boolean hungry = Boolean.TRUE;
    
    public Pet() {
        gender = PetGender.MALE;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public PetGender getGender() {
        return gender;
    }
    public void setGender(PetGender gender) {
        this.gender = gender;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }   
    public Long getMicrochip() {
        return microchip;
    }
    public void setMicrochip(Long microchip) {
        this.microchip = microchip;
    }
    
    public void eat() {
        hungry = !isHungry();       
    }

    public boolean isHungry() {
        return hungry;
    }

    public void talk() {
        System.out.println(getClass().getSimpleName() + " has a voice like " + getVoice());       
    }
    
    public abstract String getSexBySpecies();

    public abstract String getBabyName();
    
    public abstract String getVoice();

}
