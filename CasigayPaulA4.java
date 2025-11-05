import java.util.Random;
import java.util.Scanner;

/*
* COMP 1010 SECTION A02
* INSTRUCTOR: Emanuel Wiens 
* STUDENT NAME: Paul Casigay
* STUDENT NUMBER: 8061457
* ASSIGNMENT: 4
* QUESTION: 1
*
* PURPOSE: 
*/
public class CasigayPaulA4 {
    // Color constants for text formatting (use as recommended below for students)
    // These constants represent ANSI color codes to apply text color in console
    // output
    // Example: System.out.println(GREEN + "Hello World" + RESET)
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    // Word bank for the game (Should be ignored by students.)
    // A set of predefined 5-letter words used as the secret words in each game
    // round
    public static final String[] WORDS = {
            "Apple", "Bread", "Crane", "Dance", "Earth",
            "Flute", "Grape", "House", "Plant", "Jelly",
            "Knife", "Lemon", "Mango", "Nurse", "Ocean",
            "Peach", "Queen", "Radar", "Stone", "Tiger",
            "Urban", "Vivid", "Whale", "Xylog", "Yacht",
            "Zebra", "Aloha", "Blaze", "Charm", "Dream"
    };

    /***
     * Comments here
     ***/
    // main Function
    public static void main(String[] args) {
        System.out.println(PURPLE + "****** Welcome to Activate Winnipeg of Dimension W110111010 ******" + RESET);
        Scanner scan = new Scanner(System.in); // For capturing user input
        Random rand = new Random(); // Random number generator
        int aBucks = 0; // Player's A-Bucks balance

        printMenu(aBucks); // Print the initial menu

        printWordleGuess("goopa",
                "goopa");
        // TODO: complete main method
        System.out.println(waldoDuel(scan, rand));
        // System.out.println(safecracker(scan, rand));
        // System.out.println(getSuccessRate(0.3, false));
        // System.out.println(shootBasketball(0.2));
    }

    // Utility Functions *********************************

    /**
     * Displays the game menu with the current A-Bucks balance and available
     * options.
     * Input:
     * - int aBucks: The current amount of A-Bucks the player has.
     **/
    static void printMenu(int aBucks) {
        System.out.printf(CYAN + """
                Current A-Bucks: %d
                1. Safecracker
                2. Duel with Waldo
                3. Sharpshooter
                4. Hall of Prime Mirrors
                5. Wordle
                or "Exit" to Exit. \n
                """ + RESET, aBucks);
    }

    /***
     * Is true if string only contains digits
     ***/
    // isDigitsOnly Function
    static boolean isDigitsOnly(String string) {
        boolean isDigitsOnly = true;
        for (int i = 0; i < string.length(); i++) {
            // isDigitsOnly is true until there is non digit in the string
            if (!Character.isDigit(string.charAt(i))) {
                isDigitsOnly = false;
            }
        }
        return isDigitsOnly;
    }

    /***
     * Returns the absolute difference between two integers
     ***/
    // difference Function
    static int difference(int numOne, int numTwo) {
        return Math.abs(numOne - numTwo);
    }

    /***
     * Reverses an integer
     ***/
    // reverseTheNumber Function
    static int reverseTheNumber(int num) {
        String numString = Integer.toString(num);
        String reversedNumString = "";
        for (int i = numString.length() - 1; i >= 0; i--) {
            reversedNumString += numString.charAt(i);
        }
        int reversedNum = Integer.parseInt(reversedNumString);

        return reversedNum;
    }

    /***
     * Only true when both the number and its reverse are prime numbers
     ***/
    // isPrimeMirror Function
    static boolean isPrimeMirror(int num) {
        // Get the reversed number
        int reversedNum = reverseTheNumber(num);
        boolean isPrimeMirror = isPrimeNumber(num) && isPrimeNumber(reversedNum);
        return isPrimeMirror;
    }

    static boolean isPrimeNumber(int num) {
        boolean isPrimeNumber = true;
        if ((num % 2 == 0) && (num != 2)) {
            isPrimeNumber = false;
        } else {
            for (int i = 3; i < num; i += 2) {
                if ((num % i == 0) && (i != num)) {
                    isPrimeNumber = false;
                }
            }
        }
        return isPrimeNumber;
    }

    /***
     * Prints the resulting wordle guess from a word and its guess
     * A green letter is correct and matches the word's letter.
     * A yellow letter means that the word contains the letter but is at the wrong
     * position.
     * Otherwise it's incorrect.
     ***/
    // printWordleGuess Function
    static void printWordleGuess(String word, String guess) {
        String wordleString = "";
        String missingCharacters = getMissingCharacters(word, guess);
        for (int i = 0; i < word.length(); i++) {
            char guessChar = guess.charAt(i);
            int missingCharIndex = missingCharacters.indexOf(guessChar);

            if (word.charAt(i) == guess.charAt(i)) {
                wordleString += GREEN + guess.charAt(i) + RESET;
            }
            // If there is a missing character found
            else if (missingCharIndex != -1) {
                wordleString += YELLOW + guess.charAt(i) + RESET;
            } else {
                wordleString += guessChar;
            }
        }

        System.out.println(wordleString);
    }

    static String getMissingCharacters(String word, String guess) {
        String missingCharacters = "";
        // Find all wrong characters from the guess
        for (int j = 0; j < word.length(); j++) {
            // If a guess' char is found amount the missing chars
            if (word.charAt(j) != guess.charAt(j)) {
                missingCharacters += word.charAt(j);
            }
        }
        return missingCharacters;
    }

    /***
     * Returns the success rate of a teammate.
     * Gives a random success rate that is higher or lower than the initialRate
     ***/
    // getSuccessRate Function
    static double getSuccessRate(double initialRate, boolean shouldBeHigher) {
        double successRate = 0.0;
        double randomRate = 0.0;

        boolean validHigherRate = false;
        boolean validLowerRate = false;
        // Loop while there is no valid higher and lower rate
        while (!validHigherRate && !validLowerRate) {
            randomRate = getRandomNum(0.10, 1.0);

            validHigherRate = shouldBeHigher && randomRate > initialRate;
            validLowerRate = !shouldBeHigher && randomRate < initialRate;

            if (validHigherRate || validLowerRate) {
                successRate = randomRate;
            }
        }
        return successRate;
    }

    /***
     * Returns 50 A-Bucks if the
     ***/
    // shootBasketball Function
    static int shootBasketball(double successRate) {
        int aBucksWon = 0;
        double shotChance = Math.random();
        // If the shot goes in
        if (successRate > shotChance) {
            aBucksWon = 50;
        }
        return aBucksWon;
    }

    // Checks if number is in inclusive range
    static boolean isInRange(int num, int min, int max) {
        return (num >= min) && (num <= max);
    }

    static double getRandomNum(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }

    static void printWinMessage(int aBucksWon) {
        System.out.println(GREEN + "WIN +" + aBucksWon + " aBucks" + RESET);
    }

    static void printLoseMessage() {
        System.out.println(RED + "LOSE" + RESET);
    }
    // Game Functions *********************************

    /***
     * A game where you try to guess a safe's four digit combination within 15
     * tries.
     ***/
    static int safecracker(Scanner scan, Random random) {
        // abucks per remaining attempt
        final int ABUCKS_PER_ATTEMPT = 100;
        final int WIN_REWARD = 5000;

        final int COMBINATION_MIN = 0;
        final int COMBINATION_MAX = 9999;

        int attempts = 15;
        int aBucksWon = 0;

        boolean safeOpened = false;

        // Initialize a random number between [0, 10000) to be the safe combination
        int combination = random.nextInt(COMBINATION_MIN, COMBINATION_MAX + 1);
        // Display game instructions and welcome message
        System.out.println(YELLOW + """
                \n ----- Welcome to the Safecracker ----- \n
                -> You are presented with a safe that has 5000 A-Bucks in it.\n
                -> The combination to the safe is a 4 digit number made from the digits 0-9.\n
                -> You have 15 guesses until the alarm goes off and you lose the game.\n
                -> Each time, you will be hinted if the number you guessed is more than the code or less than it.\n
                -> If you finish in less than 15 trials you will get 100 A-bucks for each trial remaining! GOOD LUCK!
                         """ + RESET);

        while (attempts > 0 && !safeOpened) {
            System.out.print("Enter combination guess (attempts " + attempts + "): ");
            String guessString = scan.next();
            // If the input is not a number.
            if (!isDigitsOnly(guessString)) {
                System.out.println("Guess is not a number, try again.");
            } else {
                int guess = Integer.parseInt(guessString);
                // Guess is out of range
                if (!isInRange(guess, COMBINATION_MIN, COMBINATION_MAX)) {
                    System.out.println("Guess is out of range, try again.");
                }
                // Valid input but wrong
                else if (guess != combination) {
                    if (guess > combination) {
                        System.out.printf("%04d is higher than the combination.\n", guess);
                    } else {
                        System.out.printf("%04d is lower than the combination.\n", guess);
                    }
                }
                // Guess is corect combination
                else {
                    safeOpened = true;
                }
            }
            attempts--;
        }
        if (safeOpened) {
            aBucksWon += attempts * ABUCKS_PER_ATTEMPT;
            aBucksWon += WIN_REWARD;
            printWinMessage(aBucksWon);
        } else {
            printLoseMessage();
            System.out.println(RED + "Did not win within 15 attempts +0 aBucks won" + RESET);
        }

        return aBucksWon;
    }

    /***
     * Comments here
     ***/
    static int waldoDuel(Scanner scan, Random rand) {
        final char QUIT_KEY = 'q';

        final int WALDO_MIN = 0;
        final int WALDO_MAX = 100;
        // abucks reward for each round won
        final int WIN_REWARD = 100;

        String input = " ";

        int targetNum;
        int waldoNum;

        int waldoDifference;
        int playerDifference;

        int aBucksWon = 0;

        boolean quitKeyPressed = false;

        // Display game introduction and rules
        System.out.println(
                YELLOW + """
                        \n ----- Welcome to the Duel with Waldo game ----- \n
                        -> You are playing against \"Waldo the Number Guy\". Waldo is very good with numbers, at least that's what everyone says!\n
                        -> On each round of this game a predetermined number between [1, 100] inclusive is generated by the computer.
                        -> You and Waldo each guess a number.
                        -> Whomever's number is closer to the predetermined target number, wins the game.
                        -> You can play this game as many times as you want and to quit the game you may enter \'q\'
                        -> Each time you win, you will gain 100 A-Bucks! GOOD LUCK!
                        """
                        + RESET);

        while (!quitKeyPressed) {
            System.out.print("Pick a number between 0 and 100: ");
            input = scan.next();
            quitKeyPressed = input.charAt(0) == QUIT_KEY && input.length() == 1;

            if (quitKeyPressed) {
                System.out.println("Won " + aBucksWon + " aBucks. quiting game.");
            } else if (isDigitsOnly(input)) {
                int inputNum = Integer.parseInt(input);
                // if inputNum is in [0, 100]
                if (isInRange(inputNum, WALDO_MIN, WALDO_MAX)) {
                    waldoNum = rand.nextInt(WALDO_MIN, WALDO_MAX);
                    targetNum = rand.nextInt(WALDO_MIN, WALDO_MAX);

                    waldoDifference = difference(waldoNum, targetNum);
                    playerDifference = difference(inputNum, targetNum);

                    if (waldoDifference < playerDifference) {
                        printLoseMessage();
                        System.out.println("Target number: " + targetNum + " | Waldo's guess: " + waldoNum);
                        System.out.println("Waldo is closer than your guess.");
                    } else {
                        aBucksWon += WIN_REWARD;
                        printWinMessage(WIN_REWARD);
                        System.out.println(GREEN + "TOTAL: " + aBucksWon + " aBucks" + RESET);
                        System.out.println("Target number: " + targetNum + " | Waldo's guess: " + waldoNum);
                    }
                } else {
                    printLoseMessage();
                    System.out.println("Number is out of the range. Waldo won this round.");
                }
            } else {
                printLoseMessage();
                System.out.println("Input is not a number! Waldo won this round.");
            }
        }
        return aBucksWon;
    }

    /***
     * Comments here
     ***/
    static int sharpshooter(Scanner scan, Random rand) {
        System.out.println(
                YELLOW + """
                        \n ----- Welcome to the SharpShooter game ----- \n
                        -> In this game, you and your teammate will play a game of shooting 3-pointers in a basketball game.
                        -> You have five shots to score as many successful baskets as possible.
                        -> You have the option to either take the shot yourself or pass it to your teammate.
                        -> Each shot has a random success rate between 10% and 100%, which will be displayed before you decide.
                        -> Choose to either shoot (based on the success probability) or pass the ball.
                        -> If you pass, there is a 60% chance your teammate has a lower success rate and a 40% they have a better change.
                        -> For every successful shot, you earn 50 A-Bucks.
                                 """
                        + RESET);

        return 0;
    }

    /***
     * Comments here
     ***/
    static int primeMirrors(Scanner scan) {
        // Display game introduction and rules
        System.out.println(YELLOW + """
                \n ----- Welcome to the Hall of Prime Mirrors Game ----- \n
                -> In this challenge, you'll find numbers that are prime and whose reverse is also a prime.
                -> You will get unlimited guesses and for each correct guess, you will gain 300 A-Bucks.
                    """ + RESET);

        // TODO: Implement the rest of the function.
        return 0;
    }

    /***
     * Comments here
     ***/
    // wordle Function
    static int wordle(Scanner scan, Random rand) {
        // ***********************************************************************************************
        // */
        // Select a random target word from the WORDS array and convert it to uppercase
        // *****************
        String word = WORDS[rand.nextInt(0, 30)]; // DO NOT CHANGE *****************
        word = word.toUpperCase(); // DO NOT CHANGE *****************
        // ***********************************************************************************************
        // */

        // Display game introduction and rules
        System.out.println(
                YELLOW + """
                        \n ----- Welcome to the Wordle Game ----- \n
                        -> You are given 6 chances to guess a 5-letter word.\n
                        -> After each guess, you'll receive feedback indicating:
                            - Correct Letter and Position: If a letter is in the right position, it will be highlighted with GREEN.
                            - Correct Letter, Wrong Position: If a letter is in the word but in the wrong position, it will be marked with YELLOW.
                            - Incorrect Letter: Letters that aren't in the word at all will be marked in RED.
                        -> If you guess the entire word correctly within 6 attempts, you earn 2500-A-Bucks.
                            """
                        + RESET);

        // TODO: Implement the rest of the function.

        // Display game introduction and rules

        // Set the number of allowed trials

        // Loop until user guesses correctly or runs out of trials
        return 0;
    }

    // End Wordle

}