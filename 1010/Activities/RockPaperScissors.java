package Activities;

import java.util.Scanner;

public class RockPaperScissors {
    static final String ROCK = "Rock";
    static final String SCISSORS = "Scissors";
    static final String PAPER = "Paper";

    static final String PLAYER_WIN = "Player wins!";
    static final String COMPUTER_WIN = "Computer wins!";
    static final String DRAW = "Draw";

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        String playerMove = playerMove(scnr);
        String computerMove = computerMove();

        String gameState = getGameState(playerMove, computerMove);

        System.out.println(gameState);
    }

    static String getGameState(String playerMove, String computerMove) {
        String gameState = "";
        if (playerMove.equals(computerMove)) {
            gameState = DRAW;
        }

        else if (playerMove.equals(ROCK) && computerMove.equals(SCISSORS)) {
            gameState = PLAYER_WIN;
        } else if (playerMove.equals(ROCK) && computerMove.equals(PAPER)) {
            gameState = COMPUTER_WIN;
        }

        else if (playerMove.equals(PAPER) && computerMove.equals(SCISSORS)) {
            gameState = COMPUTER_WIN;
        } else if (playerMove.equals(PAPER) && computerMove.equals(ROCK)) {
            gameState = PLAYER_WIN;
        }

        else if (playerMove.equals(SCISSORS) && computerMove.equals(PAPER)) {
            gameState = PLAYER_WIN;
        } else if (playerMove.equals(SCISSORS) && computerMove.equals(ROCK)) {
            gameState = COMPUTER_WIN;
        }
        return gameState;
    }

    static String playerMove(Scanner scnr) {
        System.out.print("> Player move (0 Rock, 1 Paper, 2 Scissors): ");
        int playerMove = scnr.nextInt();

        String moveName = getMoveName(playerMove);

        if (isMoveInvalid(moveName)) {
            System.out.println("Invalid move");
            playerMove(scnr);
        }
        System.out.println("> Player chooses: " + moveName);

        return moveName;
    }

    static boolean isMoveInvalid(String moveName) {
        return moveName.equals("Invalid move");
    }

    static String computerMove() {
        int comuterMove = randomMove();
        String moveName = getMoveName(comuterMove);

        System.out.println("> Computer chooses: " + moveName);

        return moveName;
    }

    static int randomMove() {
        return (int) (Math.random() * 2);
    }

    static String getMoveName(int moveNumber) {
        String moveName = "";
        switch (moveNumber) {
            case 0:
                moveName = ROCK;
                break;
            case 1:
                moveName = PAPER;
                break;
            case 2:
                moveName = SCISSORS;
                break;
            default:
                moveName = "Invalid move";
                break;
        }
        return moveName;
    }
}
