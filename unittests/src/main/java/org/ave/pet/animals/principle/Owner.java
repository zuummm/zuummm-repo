package org.ave.pet.animals.principle;

import java.util.ArrayList;
import java.util.List;

import org.ave.pet.animals.Cat;
import org.ave.pet.animals.Dog;
import org.ave.pet.animals.Pet;

/**
 *  This class tries to follow as many Coding principle as the author knows :) 
 * @author Andrea_Verebi
 *
 */
public class Owner {

    private String name;
    private String address;
    private List<Pet> pets;

    public Owner() {
    }

    public Owner(String newName, String newAddress, List<Pet> pets) {
        this.name = newName;
        this.address = newAddress;
        this.pets = pets;
    }

    public void feedPet() {
        for (Pet pet : pets) {
            pet.eat();
        }
    }

    public List<Pet> getPetBySpecies(Class<? extends Pet> petClass) {
        List<Pet> filteredResult = new ArrayList<Pet>();
        if (pets != null) {
            for (Pet pet : pets) {
                if (petClass.isInstance(pet)) {
                    filteredResult.add(pet);
                }
            }
        }
        return filteredResult;
    }

    public boolean hasPet(Class<? extends Pet> petClass) {
        return !getPetBySpecies(petClass==null ? Pet.class : petClass).isEmpty();
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
