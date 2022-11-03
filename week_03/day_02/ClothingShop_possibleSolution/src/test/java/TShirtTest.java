import stock.TShirt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TShirtTest {

    private TShirt tshirt;

    @BeforeEach
    public void setUp(){
        tshirt = new TShirt(15, 5, "cotton", "women", 12, "crew");
    }

    @Test
    public void canAddGraphic__stockImage(){
        String result = tshirt.addGraphic("bicycle");
        assertThat(result).isEqualTo("T-shirt printed with bicycle: (stock image).");
    }

    @Test
    public void canAddGraphic__customImageAndWaiver(){
        String result = tshirt.addGraphic("photo", 6);
        assertThat(result).isEqualTo("T-shirt printed with photo (customer image), and waiver number 6 signed.");
    }

    @Test
    public void canCalculateMargin(){
        assertThat(tshirt.calculateMargin()).isEqualTo(10);
    }

}
