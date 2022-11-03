package enclosures;

import animals.Animal;

import java.util.ArrayList;

public class Enclosure {

    private String name;
    private ArrayList<Animal> animals;

    public Enclosure(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public int countAnimals(){
        return this.animals.size();
    }

    public void addAnimal(Animal animal){
        this.animals.add(animal);
    }
}
