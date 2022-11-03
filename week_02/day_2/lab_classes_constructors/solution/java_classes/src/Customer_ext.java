public class Customer_ext {

    private int id;
    private String firstName;
    private String lastName;

    public Customer_ext(String firstName, String lastName) {
        this.id = (int) (Math.random()*1000 + 1);
        this.firstName = firstName;
        this.lastName = lastName;
    }
    // Makes more sense to have the "amount of held money" within the Account class

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName+" "+lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
