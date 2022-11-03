package org.example;

import stuff.Pet;

public class Person {

    private String name;
    private Pet pet;

    public Person(String name, Pet pet){
        this.name = name;
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
