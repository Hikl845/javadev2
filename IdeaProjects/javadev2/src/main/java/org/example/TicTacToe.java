package org.example;

import java.util.Scanner;

public class TicTacToe {

    private static final int BOARD_SIZE = 9;
    private static final char PLAYER = 'X';
    private static final char COMPUTER = 'O';
    private static final char EMPTY = ' ';

    private static final char[] board = new char[BOARD_SIZE];

    public static void main(String[] args) {
        initBoard();
        playGame();
    }

    private static void initBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = EMPTY;
        }
    }

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard();
            playerMove(scanner);

            if (checkWin(PLAYER)) {
                printBoard();
                System.out.println("You won the game!");
                break;
            }

            if (isDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            computerMove();

            if (checkWin(COMPUTER)) {
                printBoard();
                System.out.println("Computer won the game!");
                break;
            }
        }
    }

    private static void playerMove(Scanner scanner) {
        int move;

        while (true) {
            System.out.print("Enter move (1-9): ");
            move = scanner.nextInt() - 1;

            if (isValidMove(move)) {
                board[move] = PLAYER;
                break;
            }

            System.out.println("Invalid move. Try again.");
        }
    }

    private static void computerMove() {
        int move;

        do {
            move = (int) (Math.random() * BOARD_SIZE);
        } while (!isValidMove(move));

        board[move] = COMPUTER;
    }

    private static boolean isValidMove(int index) {
        return index >= 0 && index < BOARD_SIZE && board[index] == EMPTY;
    }

    private static boolean checkWin(char symbol) {
        int[][] winPatterns = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        for (int[] pattern : winPatterns) {
            if (board[pattern[0]] == symbol &&
                    board[pattern[1]] == symbol &&
                    board[pattern[2]] == symbol) {
                return true;
            }
        }

        return false;
    }

    private static boolean isDraw() {
        for (char cell : board) {
            if (cell == EMPTY) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard() {
        System.out.println();

        for (int i = 0; i < BOARD_SIZE; i++) {

            String cell = (board[i] == EMPTY)
                    ? String.valueOf(i + 1)
                    : String.valueOf(board[i]);

            System.out.print(" " + cell);

            if (i % 3 != 2) {
                System.out.print(" |");
            }

            if (i % 3 == 2 && i != BOARD_SIZE - 1) {
                System.out.println("\n-----------");
            }
        }

        System.out.println("\n");
    }
}
