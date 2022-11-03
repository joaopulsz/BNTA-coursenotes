package stock;

import interfaces.ISell;

public abstract class ClothingItem implements ISell {

    private double cost;
    private double sellPrice;
    private String material;
    private String section;
    private int size;

    public ClothingItem(double cost, double sellPrice, String material, String section, int size){
        this.cost = cost;
        this.sellPrice = sellPrice;
        this.material = material;
        this.section = section;
        this.size = size;
    }

    public double calculateMargin(){
        double margin = this.sellPrice - this.cost;
        return margin;
    }

//    GETTERS AND SETTERS
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
