import farm.Chicken;
import farm.Farm;
import farm.Farmer;

public class App {
    public static void main(String[] args) {
        // entry point
        Farmer farmer1 = new Farmer(2000);
        Farm farm1 = new Farm(farmer1, 300, 40000);

        farm1.addChicken(new Chicken());
        farm1.addChicken(new Chicken());
        farm1.addChicken(new Chicken());
        farm1.addChicken(new Chicken());

        System.out.println("eggs: " + farm1.getEggCount());
        farm1.collectEggs();
        System.out.println("eggs: " + farm1.getEggCount());

        System.out.println("Current funds: " + farm1.getFunds());
        farm1.payFarmer();
        System.out.println("Current funds: " + farm1.getFunds());
    }
}
