package enclosures;

import animals.Animal;
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
        Animal animal = new Animal("Simba", "lion");
        enclosure.addAnimal(animal);
        int expected = 1;
        int actual = enclosure.countAnimals();
        assertEquals(expected, actual);
    }

    @Test
    public void canAddMultipleAnimals(){
        Animal lion = new Animal("Simba", "lion");
        Animal parrot = new Animal("Iago", "parrot");
        enclosure.addAnimal(lion);
        enclosure.addAnimal(parrot);
        int expected = 2;
        int actual = enclosure.countAnimals();
        assertEquals(expected, actual);
    }

}
