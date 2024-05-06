package com.coderscampus;

import java.util.Random;
import java.util.Scanner;

public class CarlosAssignment2Application {

	public static void main(String[] args) {
		Integer theRandomNumber = generateRandomNumber();
		Integer userInput = collectUserInput(theRandomNumber);
		if (userInput != null) {
			System.out.println("You win! You guessed the correct number.");
		} else {
			System.out.println("You lose! The number to guess was: " + theRandomNumber);
		}
	}

	// Method to collect and validate user input
	private static Integer collectUserInput(Integer theRandomNumber) {
		Scanner scanner = new Scanner(System.in);
		int remainingAttempts = 5; // initialize variable to validate the remaining number of attempts
		try {
			for (int i = 0; i < 5;) {
				if (i <= 4) {
					System.out.println("Pick a number between 1 and 100");
				}
				String input = scanner.nextLine();
				try {
					Integer userInput = Integer.parseInt(input);
					if (userInput < 1 || userInput > 100) {
						System.out.println("Your guess is not within 1 and 100. Please try again.");
					}
					// begins else block for handling valid user input.
					else {
						if (userInput > theRandomNumber && remainingAttempts > 1) {
							System.out.println("Pick a lower number");
						} else if (userInput < theRandomNumber && remainingAttempts > 1) {
							System.out.println("Pick a higher number");
						} else if (userInput == theRandomNumber) {  // check if user guessed correctly.
							return userInput;
						}
						remainingAttempts--;
						i++;
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter a valid number");
				}
			}
			return null;
		} finally {
			scanner.close();
		}
	}

	// Method to generate a random number between 1 and 100 inclusive.
	private static Integer generateRandomNumber() {
		Random random = new Random();
		return random.nextInt(100) + 1;
	}
}
