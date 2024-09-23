package az.edu.turing.module01.fop_projects;

import java.util.Arrays;
import java.util.Scanner;

public class GuessTheNumber {
    void main() {
        System.out.println("Let the game begin!");
        System.out.print("Enter your name: ");

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        play(sc, name);
    }

    public static void reverse(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
    }

    public static int getInput(Scanner scanner) {
        while (true) {
            System.out.print("Enter a number: ");
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
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
            guessedNumbers = Arrays.copyOf(guessedNumbers, count + 1);
            guessedNumbers[count] = userNum;
            count++;

            Arrays.sort(guessedNumbers);
            reverse(guessedNumbers);

            if (randomNum == userNum) {
                System.out.println("Congratulations, " + name);
                System.out.println("Your guessed numbers : " + Arrays.toString(guessedNumbers));
                break;
            } else if (randomNum > userNum) {
                System.out.println("Your number is too small. Please, try again.");
            } else {
                System.out.println("Your number is too big. Please, try again.");
            }
        }
    }
}
