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

	private static Integer collectUserInput(Integer theRandomNumber) {
		Scanner scanner = new Scanner(System.in);
		int remainingAttempts = 5;
		try {
			System.out.println("Pick a number between 1 and 100");
			for (int i = 0; i < 5;) {
				String input = scanner.nextLine();
				try {
					Integer userInput = Integer.parseInt(input);
					if (userInput < 1 || userInput > 100) {
						System.out.println("Your guess is not withing 1 and 100. Please try again.");
					} else {
						if (userInput > theRandomNumber && remainingAttempts > 1) {
							System.out.println("Pick a lower number");
						} else if (userInput < theRandomNumber && remainingAttempts > 1) {
							System.out.println("Pick a higher number");
						} else {
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

	private static Integer generateRandomNumber() {
		Random random = new Random();
		return random.nextInt(100) + 1;
	}
}