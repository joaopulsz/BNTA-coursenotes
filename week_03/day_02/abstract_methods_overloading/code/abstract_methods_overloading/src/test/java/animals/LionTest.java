package animals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LionTest {

    private Lion lion;

    @BeforeEach
    public void setup(){
        lion = new Lion("Simba", false);
    }

    @Test
    public void canMakeNoise(){
        String expected = "Roar!";
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
