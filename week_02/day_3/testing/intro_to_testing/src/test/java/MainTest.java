import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainTest {

    @Test
    void myFirstTest(){
        // Given - some initial setup
        String input = "HELLO";

        // When - we call the method we are testing
        String actual = input.toLowerCase();

        // Then - the result should satisfy some requirement
        String expected = "hello";
        assertThat(actual).isEqualTo(expected);
    }

}
