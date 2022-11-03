package enclosures;

import animals.Animal;
import animals.Lion;
import animals.Parrot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnclosureTest {

    private Enclosure enclosure;

    @BeforeEach
    public void setup(){
        enclosure = new Enclosure("test enclosure");
    }

    @Test
    public void canCountAnimals(){
        int expected = 0;
        int actual = enclosure.countAnimals();
        assertEquals(expected, actual);
    }

    @Test
    public void canAddAnimal(){
        Lion animal = new Lion("Simba", true);
        enclosure.addAnimal(animal);
        int expected = 1;
        int actual = enclosure.countAnimals();
        assertEquals(expected, actual);
    }

    @Test
    public void canAddMultipleAnimals(){
        Animal lion = new Lion("Simba", true);
        Animal parrot = new Parrot("Iago");
        enclosure.addAnimal(lion);
        enclosure.addAnimal(parrot);
        int expected = 2;
        int actual = enclosure.countAnimals();
        assertEquals(expected, actual);
    }

}
