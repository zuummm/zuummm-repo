package org.ave.pet;

import java.util.Arrays;

import org.ave.pet.animals.Cat;
import org.ave.pet.animals.Pet;
import org.ave.pet.animals.principle.Owner;


public class App {
    private Pet pet;
    private Owner owner;

    public App() {
        pet = new Cat();
        owner = new Owner("Andi", "Bp", Arrays.asList(pet));
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

}
