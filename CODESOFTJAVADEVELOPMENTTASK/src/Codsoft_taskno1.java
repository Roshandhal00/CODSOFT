import java.util.Random;
import java.util.Scanner;

public class Codsoft_taskno1
{
	

	public static void main(String[] args) {
		playGame();


	}
	 private static void playGame() {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        int lowerLimit = 1;
	        int upperLimit = 100;
	        int numberToGuess = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
	        int maxAttempts = 6;
	        int attempts = 0;

	        while (attempts < maxAttempts) {
	            System.out.print("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");
	            int userGuess = scanner.nextInt();
	            attempts++;

	            if (userGuess == numberToGuess) {
	                System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + attempts + " attempts.");
	                break;
	            } else if (userGuess < numberToGuess) {
	                System.out.println("Too low! Try again.");
	            } else {
	                System.out.println("Too high! Try again.");
	            }
	        }

	        if (attempts == maxAttempts) {
	            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + numberToGuess + ".");
	        }

	        System.out.print("Do you want to play again? (yes/no): ");
	        String playAgain = scanner.next().toLowerCase();
	        if (playAgain.equals("yes")) {
	            playGame();
	        } else {
	            System.out.println("Game over.");
	        }
	    }

}
