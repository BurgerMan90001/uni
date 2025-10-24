/* COMP 1010 Lab 5 Level 2: Debugging with a Debugger
 * This program should ask the user to input numbers.  It should test whether each input
 * is a number, and keep a running total of the numbers input.  Once finished entering
 * numbers, calculate the average of the numbers input.
 */

import java.util.Scanner;

public class Lab05Level2Start {
    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);
        int total = 0;
        int numNums = 0;

        String input = "0";
        // loop while the input is not q
        while (!input.equals("q")) {
            input = getUserInput(keyIn);

            boolean validNumber = checkInput(input);

            if (validNumber) {
                int num = Integer.parseInt(input);
                total += num;
                numNums++;
            } else {
                System.out.println(input + " is not a valid input. Skipping it.");
            }

        }

        double avg = (double) total / numNums;
        System.out.println("The average of the " + numNums + " numbers you entered is " + avg);

    }

    // read a line of input from the user
    static String getUserInput(Scanner s) {
        String in;
        System.out.print("Please enter a number between 1 and 100, or q to quit: ");
        in = s.nextLine();
        return in;
    }

    // test whether a string contains only digits
    static boolean checkInput(String in) {
        boolean isNumber = true;
        for (int i = 0; i < in.length(); i++) {
            char temp = in.charAt(i);
            if (!Character.isDigit(temp)) {
                isNumber = false;
            }
        }
        return isNumber;
    }
}
