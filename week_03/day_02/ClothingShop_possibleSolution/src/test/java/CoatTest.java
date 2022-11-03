import stock.Coat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CoatTest {

    private Coat coat;


    @BeforeEach
    public void setUp(){
        coat = new Coat(70, 200, "Women", "Cotton", 10, true, "zip");
    }

    @Test
    public void canAddWaterproofing(){
        coat.addWaterproofing();
        assertThat(coat.isWaterproof()).isEqualTo(true);
    }

    @Test
    public void canCalculateMargin(){
        assertThat(coat.calculateMargin()).isEqualTo(130);
    }

}
