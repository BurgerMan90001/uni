/* COMP 1010 Lab 5 Level 1: Debugging with a Debugger
 * This program should ask the user to input a string containing only letters
 * and spaces (no punctuation or other special characters). The input will be
 * validated and the user asked to try again, until acceptable input is received.
 * The program will then test if the characters 'a' and 'b' are found one after
 * the other in the input, and print a message with the result.
 */

import java.util.Scanner;

public class Lab05Level1Start {
	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);

		String input = "0";
		boolean valid = false;
		// loop while the input is not valid
		while (!valid) {

			input = getUserInput(keyIn);

			valid = checkInput(input);

			if (!valid) {
				System.out.println(input + " is not a valid input. Please try again.");
			}
		}

		boolean hasAB = findPair(input, 'a', 'b');

		if (hasAB) {
			System.out.println("Your string \"" + input + "\" contains \"ab\".");
		} else {
			System.out.println("Your string \"" + input + "\" does not contain \"ab\".");
		}

	}

	// read a line of input from the user
	static String getUserInput(Scanner s) {
		String in;
		System.out.print("Please enter some text that contains only letters and spaces: ");
		in = s.nextLine();
		return in;
	}

	// test whether a string contains only letters and spaces
	static boolean checkInput(String in) {
		boolean isLetters = true;
		for (int i = 0; i < in.length() - 1; i++) {
			char temp = in.charAt(i);
			// set isLetters to false when its not ' ' and not a letter
			if ((!Character.isLetter(temp) && temp != ' ')) {
				isLetters = false;
			}
		}
		return isLetters;
	}

	// test whether a pair of characters is found consecutively in a string
	static boolean findPair(String s, char first, char second) {
		// made found false
		boolean found = false;
		for (int i = 0; i < s.length(); i++) {
			// got rid of else
			if (s.charAt(i) == first && s.charAt(i + 1) == second) {
				found = true;
			}
		}
		return found;
	}
}
