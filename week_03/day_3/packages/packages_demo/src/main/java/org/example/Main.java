package org.example;

import stuff.Pet;
import stuff.Toy;

public class Main {
    public static void main(String[] args) {

        Toy toy = new Toy("ball");

        // Can't call the method from here as it is package-private
//        toy.makeNoise();

        Pet pet = new Pet("Ella", "Tortoise", toy);

        Person person = new Person("Colin", pet);

        person.setName("Zsolt");

    }
}