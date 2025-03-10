import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean restart = true;
        String userResponse;

        System.out.println("====== Min Htut Hein's Number Guessing Game ======");

        while (restart) {
            int randNum = rand.nextInt(100) + 1;
            int userNum = 0;
            int attempt = 0;
            boolean correctGuess = false;

            System.out.println("I have selected a number between 1 and 100. Try to guess it!");

            while (!correctGuess) {
                // Validate user input for number guessing
                while (true) {
                    System.out.print("Enter your guess number (1-100): ");
                    if (input.hasNextInt()) {  // Check if input is an integer
                        userNum = input.nextInt();
                        if (userNum >= 1 && userNum <= 100) {  // Check if within range
                            break;
                        } else {
                            System.out.println("❌ Your input is invalid! Please enter a number between 1 and 100.");
                        }
                    } else {
                        System.out.println("❌ Your input is invalid! Please enter an integer number.");
                        input.next(); // Clear invalid input
                    }
                }
                attempt++;

                if (userNum > randNum) {
                    System.out.println("The number is too big! Please try again.");
                } else if (userNum < randNum) {
                    System.out.println("The number is too small! Please try again.");
                } else {
                    System.out.println("🎉 Congratulations!! You guessed the number in " + attempt + " attempts.");
                    correctGuess = true;
                }
            }

            // Validate user input for playing again
            while (true) {
                System.out.print("Do you want to play again? (yes/no): ");
                userResponse = input.next().toLowerCase();

                if (userResponse.equals("yes")) {
                    restart = true;
                    break;
                } else if (userResponse.equals("no")) {
                    restart = false;
                    System.out.println("Thank you for playing Min Htut Hein's Number Guessing Game! 😊 Goodbye!");
                    break;
                } else {
                    System.out.println("❌ Your input is invalid! Please enter 'yes' or 'no'.");
                }
            }
        }

        input.close();
    }
}
