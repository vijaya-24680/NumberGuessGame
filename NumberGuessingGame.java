import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        try (Scanner scanner = new Scanner(System.in)) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfTries = 0;
            boolean hasGuessedCorrectly = false;

            while (!hasGuessedCorrectly) {
                System.out.print("Guess a number between 1 and 100: ");
                try {
                    int guess = scanner.nextInt();
                    numberOfTries++;

                    if (guess < 1 || guess > 100) {
                        System.out.println("Please enter a number between 1 and 100.");
                    } else if (guess < numberToGuess) {
                        System.out.println("Too low!");
                    } else if (guess > numberToGuess) {
                        System.out.println("Too high!");
                    } else {
                        hasGuessedCorrectly = true;
                        System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("That's not a valid number. Please try again.");
                    scanner.next(); // clear the invalid input
                }
            }
        }
    }
}