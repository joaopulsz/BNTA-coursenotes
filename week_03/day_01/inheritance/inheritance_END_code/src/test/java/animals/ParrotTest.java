package animals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParrotTest {

    private Parrot parrot;

    @BeforeEach
    public void setUp(){
        parrot = new Parrot("Iago");
    }

    @Test
    public void canMakeNoise(){
        String expected = "Squawk!";
        String actual = parrot.makeNoise();
        assertEquals(expected, actual);
    }

    @Test
    public void canEat(){
        String expected = "Mmm, that was tasty!";
        String actual = parrot.eat();
        assertEquals(expected, actual);
    }

    @Test
    public void canLayEgg(){
        String expected = "I laid an egg!";
        String actual = parrot.layEgg();
        assertEquals(expected, actual);
    }

    @Test
    public void canSayName(){
        String expected = "My name is Iago.";
        String actual = parrot.sayName();
        assertEquals(expected, actual);
    }

}
