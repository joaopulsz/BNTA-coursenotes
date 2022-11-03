package animals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeagullTest {

    private Seagull seagull;

    @BeforeEach
    public void setUp(){
        seagull = new Seagull("Scuttle");
    }

    @Test
    public void canLayEgg(){
        String expected = "I laid an egg!";
        String actual = seagull.layEgg();
        assertEquals(expected, actual);
    }

    @Test
    public void canEat(){
        String expected = "Mmm, that was tasty!";
        String actual = seagull.eat();
        assertEquals(expected, actual);
    }

}
