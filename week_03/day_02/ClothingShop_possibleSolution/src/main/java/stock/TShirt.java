package stock;

public class TShirt extends ClothingItem {

    private String neckline;

    public TShirt(double sellPrice, double cost, String material, String section, int size, String neckline){
        super(cost, sellPrice, material, section, size);
        this.neckline = neckline;
    }

    public String addGraphic(String stockImage){
        return "T-shirt printed with " + stockImage + ": (stock image).";
    }

    public String addGraphic(String customerImage, int waiverNumber){
        return String.format("T-shirt printed with %s (customer image), and waiver number %d signed.", customerImage, waiverNumber);
    }

//    GETTERS AND SETTERS

    public String getNeckline() {
        return neckline;
    }

    public void setNeckline(String neckline) {
        this.neckline = neckline;
    }
}
