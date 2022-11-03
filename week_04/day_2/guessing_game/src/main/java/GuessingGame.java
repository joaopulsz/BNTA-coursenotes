import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    private int secretNumber;
    private int playerGuess;
    private boolean stillPlaying;

    public GuessingGame() {
        secretNumber = new Random().nextInt(100);
    }

    public void start(){
        stillPlaying = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Guess a number between 0 and 100:");

        while (stillPlaying){

            this.playerGuess = scanner.nextInt();


            if (playerGuess > secretNumber) {
                System.out.println("Too high!");
            } else if (playerGuess < secretNumber) {
                System.out.println("Too low!");
            }
            else {
                System.out.println("Congratulations!");
                stillPlaying = false;
            }
        }
    }

}
