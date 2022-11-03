package animals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    private Animal lion;

    @BeforeEach
    public void setup(){
        lion = new Animal("Simba", "lion");
    }

    @Test
    public void canMakeNoise(){
        String expected = "Hello, my name is Simba.";
        String actual = lion.makeNoise();
        assertEquals(expected, actual);
    }

    @Test
    public void canEat(){
        String expected = "Mmm, that was tasty!";
        String actual = lion.eat();
        assertEquals(expected, actual);
    }

}
