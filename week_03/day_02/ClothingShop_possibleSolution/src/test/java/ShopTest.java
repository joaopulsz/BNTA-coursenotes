import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop.Shop;
import stock.ClothingItem;
import stock.Coat;
import stock.Perfume;
import stock.TShirt;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ShopTest {

    private Shop shop;
    private Perfume perfume;
    private TShirt tshirt;
    private Coat coat;

    @BeforeEach
    public void setUp(){
        shop = new Shop("BN Clothing");
        perfume = new Perfume("Sunflowers", "grapefruit", 2, 45);
        tshirt = new TShirt(15, 7, "cotton", "kids", 9, "crew");
        coat = new Coat(70, 150, "women", "cotton", 14, true, "zip");
    }

    @Test
    public void canAddItemToStock(){
        shop.addItemToStock(perfume);
        shop.addItemToStock(coat);
        assertThat(shop.stockCount()).isEqualTo(2);
    }

    @Test
    public void canCalculateProjectedProfit(){
        shop.addItemToStock(perfume);
        shop.addItemToStock(coat);
        shop.addItemToStock(tshirt);
        assertThat(shop.calculateProjectedProfit()).isEqualTo(131);
    }


}
