package stock;

import interfaces.ISell;

import java.time.LocalTime;

public class Perfume implements ISell {

    private String name;
    private String topNote;
    private double cost;
    private double sellPrice;

    public Perfume(String name, String topNote, double cost, double sellPrice){
        this.name = name;
        this.topNote = topNote;
        this.cost = cost;
        this.sellPrice = sellPrice;
    }

    public double calculateMargin(){
        double margin = this.sellPrice - this.cost;
        return margin;
    }

//    GETTERS AND SETTERS


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopNote() {
        return topNote;
    }

    public void setTopNote(String topNote) {
        this.topNote = topNote;
    }

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
}
