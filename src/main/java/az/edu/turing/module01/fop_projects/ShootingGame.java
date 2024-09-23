package az.edu.turing.module01.fop_projects;

import java.util.Scanner;

public class ShootingGame {
    public static void main(String[] args) {
        System.out.println("All set. Get ready to rumble!");
        char[][] board = initializeBoard(5, 5);
        int[] randomTarget = createRandomPositions(5, 5);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int row = getInput(scanner, "row", 5);
            int col = getInput(scanner, "column", 5);

            if (randomTarget[0] == row && randomTarget[1] == col) {
                board[row][col] = 'x';
                System.out.println("You have won!");
                break;
            } else {
                board[row][col] = '*';
            }
            displayBoard(board);
        }
    }

    public static char[][] initializeBoard(int rows, int cols) {
        char[][] board = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '-';
            }
        }
        return board;
    }

    public static int[] createRandomPositions(int rows, int cols) {
        int randomRow = (int) (Math.random() * rows);
        int randomCol = (int) (Math.random() * cols);
        return new int[]{randomRow, randomCol};
    }

    public static int getInput(Scanner scan, String input, int bound) {
        int value = 0;
        while (true) {
            System.out.print("Enter a " + input + ": ");
            if (scan.hasNextInt()) {
                value = scan.nextInt() - 1;
                if (value >= 0 && value < 5) {
                    break;
                }
            } else {
                scan.next();
            }
            System.out.println("Enter a valid " + input);

        }
        return value;
    }

    public static void displayBoard(char[][] board) {
        for (int i = 0; i <= 5; i++) {
            System.out.print(i + " | ");
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
