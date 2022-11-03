package stock;

public class Coat extends ClothingItem {

    private boolean hood;
    private String fastening;
    private boolean waterproof;

    public Coat(double cost, double sellPrice, String section, String material, int size, boolean hood, String fastening){
        super(cost, sellPrice, section, material, size);
        this.hood = hood;
        this.fastening = fastening;
        this.waterproof = false;
    }

    public void addWaterproofing(){
        setWaterproof(true);
    }

//    GETTERS AND SETTERS

    public boolean isHood() {
        return hood;
    }

    public void setHood(boolean hood) {
        this.hood = hood;
    }

    public String getFastening() {
        return fastening;
    }

    public void setFastening(String fastening) {
        this.fastening = fastening;
    }

    public boolean isWaterproof() {
        return waterproof;
    }

    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }
}
