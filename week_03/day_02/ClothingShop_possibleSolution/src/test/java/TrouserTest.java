import stock.Trouser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TrouserTest {

    private Trouser trouser;

    @BeforeEach
    public void setUp(){
        trouser = new Trouser(15, 35, "linen", "kids", 11, "elastic", 25);
    }

    @Test
    public void canHemTrouser(){
        trouser.hemming(2);
        assertThat(trouser.getLegLength()).isEqualTo(23);
    }

    @Test
    public void canCalculateMargin(){
        assertThat(trouser.calculateMargin()).isEqualTo(20);
    }

}
