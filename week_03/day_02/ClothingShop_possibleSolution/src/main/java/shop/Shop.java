package shop;

import interfaces.ISell;
import stock.ClothingItem;
import stock.TShirt;

import java.util.ArrayList;

public class Shop {

    private String name;
    private double till;
    private ArrayList<ISell> stock;

    public Shop(String name){
        this.name = name;
        this.till = 0;
        this.stock = new ArrayList<>();
    }

    public void addItemToStock(ISell item){
        this.stock.add(item);
    }

    public int stockCount(){
        return this.stock.size();
    }

    public double calculateProjectedProfit(){
        double profit = 0;
        for (ISell item : stock){
            profit += item.calculateMargin();
        }
        return profit;
    }

//    GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTill() {
        return till;
    }

    public void setTill(double till) {
        this.till = till;
    }

    public ArrayList<ISell> getStock() {
        return stock;
    }

    public void setStock(ArrayList<ISell> stock) {
        this.stock = stock;
    }

}
