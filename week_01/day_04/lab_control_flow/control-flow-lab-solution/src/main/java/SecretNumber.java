import java.util.Scanner;

public class SecretNumber {

    public static void main(String[] args) {

        int secretNumber = 23;

        System.out.println("Guess what number I am thinking of (it's between 1 & 50): ");

        Scanner reader = new Scanner(System.in);
        int guessNumber = reader.nextInt();

        if (guessNumber < secretNumber){
            System.out.println("Too low!");
        } else if (guessNumber > secretNumber){
            System.out.println("Too High!");
        } else if (guessNumber == 23) {
            System.out.println("Correct!");
        }

    }

}
