public class Account_ext {

    String id;
    Customer_ext owner;
    int balance;

    public Account_ext(String id, Customer_ext owner, int balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer_ext getOwner() {
        return owner;
    }

    public void setOwner(Customer_ext owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addBalance(int toAdd) {
        setBalance(balance+toAdd);
    }

    public void subtractBalance(int toSubtract) {
        setBalance(balance-toSubtract);
    }

    @Override
    public String toString() {
        return "Account{" + "id='" + id + ", name='" + owner + ", balance=" + balance + '}';
    }
}
