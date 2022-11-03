import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        this.calculator = new Calculator();
    }

    @Test
    public void canAddNumbers(){
       //Given
       //When
       int actual = calculator.add(3,2);
       //Then
         int expected = 5;
         assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canSubtractNumbers(){
        int actual = calculator.subtract(3,2);
        int expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canSubtractNegativeNumber(){
        int actual = calculator.subtract(3, -2);
        int expected = 5;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canDoubleIfDivisible(){
        int actual = calculator.doubleIfDivisibleBy(4, 2);
        int expected = 8;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canMultiply(){
        int expected = 8;
        int actual = calculator.multiply(4, 2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void fourDivisibleByTwo(){
        boolean actual = calculator.isDivisibleBy(4, 2);
        assertThat(actual).isTrue();
    }
}
