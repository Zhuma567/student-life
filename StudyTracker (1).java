import java.util.Scanner;

public class StudyTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int weeklyGoal = 600;

        // Totals: everything starts at 0
        int programmingTotal = 0;
        int mathTotal = 0;
        int englishTotal = 0;
        int otherTotal = 0;
        int totalStudyTime = 0;
        int sessionCount = 0;

        int choice = 0;

        while (choice != 4) {
            System.out.println("===== STUDY TRACKER =====");
            System.out.println();
            System.out.println("1. Add study session");
            System.out.println("2. View statistics");
            System.out.println("3. Check weekly goal");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                scanner.next(); // throw away non-numeric input
                System.out.println("Invalid option. Please choose from 1 to 4.");
                System.out.println();
                continue;
            }
            choice = scanner.nextInt();
            System.out.println();

            if (choice == 1) {
                System.out.println("Choose subject:");
                System.out.println("1. Programming");
                System.out.println("2. Mathematics");
                System.out.println("3. English");
                System.out.println("4. Other");
                System.out.println();
                System.out.print("Choose an option: ");

                if (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println("Invalid subject choice. Please choose from 1 to 4.");
                    System.out.println();
                    continue;
                }
                int subject = scanner.nextInt();

                if (subject < 1 || subject > 4) {
                    System.out.println("Invalid subject choice. Please choose from 1 to 4.");
                    System.out.println();
                    continue; // no session added, back to menu
                }

                System.out.print("Study time in minutes: ");
                if (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println("Invalid study time. Time must be greater than 0.");
                    System.out.println();
                    continue;
                }
                int minutes = scanner.nextInt();

                if (minutes <= 0) {
                    System.out.println("Invalid study time. Time must be greater than 0.");
                    System.out.println();
                    continue; // no totals changed
                }

                // 1. add to subject total
                if (subject == 1) {
                    programmingTotal += minutes;
                } else if (subject == 2) {
                    mathTotal += minutes;
                } else if (subject == 3) {
                    englishTotal += minutes;
                } else {
                    otherTotal += minutes;
                }
                // 2. add to total, 3. count the session
                totalStudyTime += minutes;
                sessionCount++;

                // 4. show updated total
                System.out.println();
                System.out.println("Study session added!");
                System.out.println("Current total study time: " + totalStudyTime + " minutes");
                System.out.println();

            } else if (choice == 2) {
                System.out.println("===== WEEKLY STATISTICS =====");
                System.out.println();
                System.out.println("Study sessions: " + sessionCount);
                System.out.println("Total study time: " + totalStudyTime + " minutes");
                System.out.println();
                System.out.println("Programming: " + programmingTotal + " minutes");
                System.out.println("Mathematics: " + mathTotal + " minutes");
                System.out.println("English: " + englishTotal + " minutes");
                System.out.println("Other: " + otherTotal + " minutes");
                System.out.println();

            } else if (choice == 3) {
                System.out.println("Weekly goal: " + weeklyGoal + " minutes");
                System.out.println("You studied: " + totalStudyTime + " minutes");
                if (totalStudyTime >= weeklyGoal) {
                    System.out.println("Weekly goal achieved!");
                } else {
                    System.out.println("Remaining: " + (weeklyGoal - totalStudyTime) + " minutes");
                }
                System.out.println();

            } else if (choice == 4) {
                System.out.println("Study tracker closed. Keep up the good work!");

            } else {
                System.out.println("Invalid option. Please choose from 1 to 4.");
                System.out.println();
            }
        }

        scanner.close();
    }
}
