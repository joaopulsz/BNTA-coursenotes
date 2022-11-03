import stock.Perfume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PerfumeTest {

    private Perfume perfume;

    @BeforeEach
    public void setUp(){
        perfume = new Perfume("Sunflowers", "grapefuit",2, 50);
    }

    @Test
    public void canCalculateMargin(){
        assertThat(perfume.calculateMargin()).isEqualTo(48);
    }

}
