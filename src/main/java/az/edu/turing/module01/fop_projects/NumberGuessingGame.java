package az.edu.turing.module01.fop_projects;

import java.util.Arrays;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        System.out.println("Let the game begin!");
        System.out.print("Enter your name: ");

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        play(sc, name);
    }

    public static void print(int[] guessedNumbers, int count) {
        for (int i = count-1; i > 0; i--) {
            System.out.print(guessedNumbers[i] + " ");
        }
    }

    public static int getInput(Scanner scanner) {
        while (true) {
            System.out.print("Enter a number(1-100): ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number > 0 && number < 100) {
                    return number;
                } else {
                    System.out.println("Invalid input! Enter a number between 1 and 100");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }
    }

    public static void play(Scanner scanner, String name) {
        int randomNum = (int) (Math.random() * 100) + 1;
        int count = 0;
        int[] guessedNumbers = new int[100];
        while (true) {
            int userNum = getInput(scanner);
            guessedNumbers[count] = userNum;
            count++;

            if (randomNum == userNum) {
                System.out.println("Congratulations, " + name);
                break;
            } else if (randomNum > userNum) {
                System.out.println("Your number is too small. Please, try again.");
            } else {
                System.out.println("Your number is too big. Please, try again.");
            }
        }
        Arrays.sort(guessedNumbers, 0, count);
        print(guessedNumbers, count);
    }
}
