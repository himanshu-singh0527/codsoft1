import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        Random random = new Random(); 
        boolean playAgain = true; 
        int totalRounds = 0; 
        int totalScore = 0; 

        while (playAgain) { 
            int numberToGuess = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int numberOfAttempts = 0; 
            boolean hasGuessedCorrectly = false; 
            final int MAX_ATTEMPTS = 10; 

            System.out.println("I have generated a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts.");

            while (!hasGuessedCorrectly && numberOfAttempts < MAX_ATTEMPTS) { // Loop for attempts within a round
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt(); // Read user guess
                numberOfAttempts++; // Increment attempts counter

                // Compare the guess with the generated number and provide feedback
                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true; // Set flag to true if guess is correct
                    System.out.println("Congratulations! You guessed the correct number.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high. Try again.");
                } else {
                    System.out.println("Your guess is too low. Try again.");
                }
            }

            // Provide feedback if the user did not guess the number within the allowed attempts
            if (!hasGuessedCorrectly) {
                System.out.println("You've used all attempts. The correct number was " + numberToGuess);
            }

            totalRounds++; 
            // Update the score based on the remaining attempts if the user guessed correctly
            totalScore += hasGuessedCorrectly ? MAX_ATTEMPTS - numberOfAttempts + 1 : 0;

            // Ask the user if they want to play another round
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes"); // Update playAgain flag based on user input
        }

        System.out.println("Game over! You played " + totalRounds + " rounds with a total score of " + totalScore + ".");
    }
}
