package zoo;

import animals.Animal;
import animals.Lion;
import enclosures.Enclosure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZooTest {

    private Zoo zoo;
    private Enclosure enclosure1;
    private Enclosure enclosure2;
    private Enclosure enclosure3;


    @BeforeEach
    public void setup(){
        enclosure1 = new Enclosure("test enclosure 1");
        enclosure2 = new Enclosure("test enclosure 2");
        enclosure3 = new Enclosure("test enclosure 3");
        zoo = new Zoo(enclosure1, enclosure2, enclosure3);
    }

    @Test
    public void canAddAnimalToEnclosure(){
        Animal animal = new Lion("Simba", false);
        zoo.addAnimalToEnclosure(animal, enclosure1);
        int expected = 1;
        int actual = enclosure1.countAnimals();
        assertEquals(expected, actual);
    }

}
