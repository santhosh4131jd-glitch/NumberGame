import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;  // Step 7: Track score
        boolean playAgain = true;

        System.out.println("🎯 Welcome to the Number Guessing Game! 🎯");

        while (playAgain) {
            // Step 1: Generate a random number
            int secretNumber = rand.nextInt(100) + 1; // Random number between 1–100
            int attempts = 0;
            int maxAttempts = 7; // Step 5: Limit number of attempts
            boolean guessed = false;

            System.out.println("\nI'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            // Step 2–4: Let user guess until correct or attempts used up
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                // Step 3: Compare guess and give feedback
                if (guess < secretNumber) {
                    System.out.println("📉 Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("📈 Too high! Try again.");
                } else {
                    System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts!");
                    guessed = true;
                    score += (maxAttempts - attempts + 1) * 10; // Step 7: Calculate score
                    break;
                }
            }

            // Step 4 (continued): If not guessed
            if (!guessed) {
                System.out.println("😢 Out of attempts! The correct number was " + secretNumber + ".");
            }

            // Step 6: Ask to play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next().toLowerCase();
            if (!choice.equals("yes")) {
                playAgain = false;
            }
        }

        // Step 7: Display final score
        System.out.println("\n Game Over!");
        System.out.println("Your Final Score: " + score);
        System.out.println("Thanks for playing! 😊");

        sc.close();
    }
}
