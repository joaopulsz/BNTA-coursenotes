package zoo;

import animals.Animal;
import animals.Lion;
import animals.Parrot;
import animals.Seagull;
import enclosures.Enclosure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZooTest {

    private Zoo zoo;
    private Enclosure reptileHouse;
    private Enclosure birdCage;
    private Enclosure mammalField;


    @BeforeEach
    public void setup(){
        reptileHouse = new Enclosure("test enclosure 1");
        birdCage = new Enclosure("test enclosure 2");
        mammalField = new Enclosure("test enclosure 3");
        zoo = new Zoo(reptileHouse, birdCage, mammalField);
    }

    @Test
    public void canAddAnimalToEnclosure(){
        Animal animal = new Lion("Simba", false);
        zoo.addAnimalToEnclosure(animal, mammalField);
        int expected = 1;
        int actual = mammalField.countAnimals();
        assertEquals(expected, actual);
    }

}
