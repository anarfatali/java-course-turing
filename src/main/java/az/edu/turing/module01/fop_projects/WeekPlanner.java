package az.edu.turing.module01.fop_projects;

import java.util.Scanner;

public class WeekPlanner {
    public static void main(String[] args) {
        String[][] schedule = initializeSchedule();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Please, input the day of the week: ");
            String line = scanner.nextLine().trim().toLowerCase();

            if (line.startsWith("change")) {
                String[] divisions = line.split(" ");
                String day = divisions[1];
                changeTasks(scanner, schedule, divisions[1]);
            } else if (line.equalsIgnoreCase("exit")) {
                System.exit(0);
            } else {
                printTasks(schedule, line);
            }
        }
    }

    public static String[][] initializeSchedule() {
        String[][] schedule = new String[7][2];
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do home work, cook meals";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses, watch a film";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "go to park, do cycling";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "visit cousins, go for a walk";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "solve leetcode problems, make a project";
        schedule[5][0] = "Friday";
        schedule[5][1] = "meet with friends, do some research";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "play video games, read some book";
        return schedule;
    }

    public static void printTasks(String[][] schedule, String day) {
        int dayIndex = getDayIndex(day);
        if (dayIndex == -1) {
            System.out.println("Sorry, I don't understand you, please try again.");
        } else {
            System.out.println("Your tasks for " + schedule[dayIndex][0] + ": " + schedule[dayIndex][1]);
        }
    }

    public static void changeTasks(Scanner scanner, String[][] schedule, String day) {
        int dayIndex = getDayIndex(day);
        if (dayIndex == -1) {
            System.out.println("Sorry, I don't understand you, please try again.");
            return;
        }
        System.out.print("Input tasks for " + schedule[dayIndex][0] + ": ");
        schedule[dayIndex][1] = scanner.nextLine();
        System.out.println("Tasks updated successfully!");
    }

    public static int getDayIndex(String day) {
        switch (day) {
            case "sunday" -> {
                return 0;
            }
            case "monday" -> {
                return 1;
            }
            case "tuesday" -> {
                return 2;
            }
            case "wednesday" -> {
                return 3;
            }
            case "thursday" -> {
                return 4;
            }
            case "friday" -> {
                return 5;
            }
            case "saturday" -> {
                return 6;
            }
            default -> {
                return -1;
            }
        }
    }
}
