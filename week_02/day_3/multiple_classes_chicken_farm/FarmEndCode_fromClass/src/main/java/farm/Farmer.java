package farm;

public class Farmer {
    private int salary;
    private int balance;

    public Farmer(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void feedChickens() {
        // todo: feed chickens logic
    }

    public void acceptPayment(int payment) {
        balance += payment;
    }

}
