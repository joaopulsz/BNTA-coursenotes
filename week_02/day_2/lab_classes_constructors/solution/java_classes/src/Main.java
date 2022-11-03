import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // SET UP
        Scanner scanner = new Scanner(System.in);

        // EXAMPLE - Account
        Account myAccount = new Account("1", "Bernadine", 300);
        System.out.println(myAccount);
        System.out.println(myAccount.getBalance());


        // MVP 1/3 - Circle
        Circle myCircle = new Circle(10);

        System.out.println("RADIUS: "+myCircle.getRadius());
        System.out.println("CIRCUMFERENCE: "+myCircle.getCircumference());

        // - Setting a new Radius value
        myCircle.setRadius(15);

        System.out.println("RADIUS: "+myCircle.getRadius());
        System.out.println("CIRCUMFERENCE: "+myCircle.getCircumference());


        // MVP 2/3 - Rectangle
        Rectangle myRectangle = new Rectangle(10, 12);

        System.out.println("PERIMETER :"+myRectangle.getPerimeter());
        System.out.println("AREA: "+myRectangle.getArea());
        System.out.println("DIAGONAL: "+myRectangle.getDiagonal());


        // MVP 3/3 - Customer
        Customer stan = new Customer("Stan", "Moat", 100);

        System.out.println("FULL NAME: "+stan.getFullName());
        System.out.println("HELD MONEY: "+stan.getHeldMoney());

        // - Using the subtractHeldMoney method
        stan.subtractHeldMoney(20);
        System.out.println("HELD MONEY AFTER SUBTRACTION: "+stan.getHeldMoney());

        Account stanAccount = new Account("1", "Stan", 500);

        System.out.println(stanAccount.toString());


        // EXTENSIONS

        System.out.println("Please enter the customer's first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Please enter the customer's surname: ");
        String surname = scanner.nextLine();

        Customer_ext newCustomer = new Customer_ext(firstName, surname);

        System.out.println(newCustomer.toString());

        Account_ext newAccount = new Account_ext("1", newCustomer, 400);

        System.out.println("New account created: ");
        System.out.println(newAccount);

        Boolean applicationRunning = true;

        while (applicationRunning) {
            System.out.println("Would you like to perform an action on your account? ADD/SUBTRACT/EXIT");
            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "exit": {
                    applicationRunning = false;
                    break;
                }
                case "add": {
                    System.out.println("How much would you like to add to your account?");
                    if (scanner.hasNextInt()) {
                        int toAdd = scanner.nextInt();
                        scanner.nextLine();
                        newAccount.addBalance(toAdd);
                        System.out.println("Your new balance is: "+newAccount.getBalance());
                    } else {
                        System.out.println("Please input a valid numerical value");
                    }
                    break;
                }
                case "subtract": {
                    System.out.println("How much would you like to subtract from your account?");
                    if (scanner.hasNextInt()) {
                        int toSubtract = scanner.nextInt();
                        scanner.nextLine();
                        newAccount.subtractBalance(toSubtract);
                        System.out.println("Your new balance is: "+newAccount.getBalance());
                    } else {
                        System.out.println("Please input a valid numerical value");
                    }
                    break;
                }
            }
        }
    }
}