package farm;

import java.util.ArrayList;

public class Farm {
    private ArrayList<Chicken> chickens;
    private Farmer farmer;
    private int unitsOfFeed;
    private int funds;
    private int eggs;

    public Farm(Farmer farmer, int unitsOfFeed, int funds) {
        this.chickens = new ArrayList<>();
        this.farmer = farmer;
        this.unitsOfFeed = unitsOfFeed;
        this.funds = funds;
        this.eggs = 0;
    }

    public void payFarmer() {
        if(this.funds > farmer.getSalary()) {
            farmer.acceptPayment(farmer.getSalary());
            funds -= farmer.getSalary();
        }
        else {
            System.out.println("So sorry, but we're broke. No money for you.");
        }
    }

    public void feedChickens() {
        for(Chicken chicken : this.chickens) {
            // this code runs for every chicken in the array list
            if(unitsOfFeed >= 1) {
                chicken.eat();
                unitsOfFeed--;
            }
            else {
                System.out.println("Sorry chicken, no food left for you");
            }

        }
       // unitsOfFeed -= chickens.size();
    }

    public void collectEggs() {
        this.eggs += this.chickens.size();
    }

    public void addChicken(Chicken chicken) {
        this.chickens.add(chicken);
    }

    public int getEggCount() {
        return eggs;
    }

    public int getFunds() {
        return funds;
    }
}
