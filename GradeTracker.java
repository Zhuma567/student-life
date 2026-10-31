import java.util.Scanner;

public class GradeTracker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double assignmentPoints = 0;
        int assignmentCount = 0;
        double examPoints = 0;
        int examCount = 0;

        boolean running = true;

        while (running) {
            System.out.println("\n===== SEMESTER GRADE TRACKER =====");
            System.out.println("1. Add assignment result");
            System.out.println("2. Add exam result");
            System.out.println("3. View current grade");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid menu choice. Enter a number from 1 to 4.");
                input.next();
                continue;
            }

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter assignment score: ");
                    if (!input.hasNextDouble()) {
                        System.out.println("Invalid score. Enter a value from 0 to 100.");
                        input.next();
                        break;
                    }

                    double assignmentScore = input.nextDouble();
                    if (assignmentScore < 0 || assignmentScore > 100) {
                        System.out.println("Invalid score. Enter a value from 0 to 100.");
                        break;
                    }

                    assignmentPoints += assignmentScore;
                    assignmentCount++;
                    System.out.println("Assignment score added.");
                    break;

                case 2:
                    System.out.print("Enter exam score: ");
                    if (!input.hasNextDouble()) {
                        System.out.println("Invalid score. Enter a value from 0 to 100.");
                        input.next();
                        break;
                    }

                    double examScore = input.nextDouble();
                    if (examScore < 0 || examScore > 100) {
                        System.out.println("Invalid score. Enter a value from 0 to 100.");
                        break;
                    }

                    examPoints += examScore;
                    examCount++;
                    System.out.println("Exam score added.");
                    break;

                case 3:
                    if (assignmentCount == 0 && examCount == 0) {
                        System.out.println("No results available yet.");
                        break;
                    }

                    System.out.println("\n===== CURRENT RESULTS =====");

                    double assignmentAverage = 0;
                    double examAverage = 0;

                    if (assignmentCount > 0) {
                        assignmentAverage = assignmentPoints / assignmentCount;
                        System.out.println("Assignments completed: " + assignmentCount);
                        System.out.printf("Assignment average: %.1f%n", assignmentAverage);
                    } else {
                        System.out.println("No assignment results entered yet.");
                    }

                    if (examCount > 0) {
                        examAverage = examPoints / examCount;
                        System.out.println("Exams completed: " + examCount);
                        System.out.printf("Exam average: %.1f%n", examAverage);
                    } else {
                        System.out.println("No exam results entered yet.");
                    }

                    double overallAverage;
                    if (assignmentCount > 0 && examCount > 0) {
                        overallAverage = assignmentAverage * 0.50 + examAverage * 0.50;
                    } else if (assignmentCount > 0) {
                        overallAverage = assignmentAverage;
                        System.out.println("Overall average uses the assignment average because no exam results exist.");
                    } else {
                        overallAverage = examAverage;
                        System.out.println("Overall average uses the exam average because no assignment results exist.");
                    }

                    String grade;
                    if (overallAverage >= 90) {
                        grade = "A";
                    } else if (overallAverage >= 80) {
                        grade = "B";
                    } else if (overallAverage >= 70) {
                        grade = "C";
                    } else if (overallAverage >= 60) {
                        grade = "D";
                    } else {
                        grade = "F";
                    }

                    System.out.printf("Overall average: %.1f%n", overallAverage);
                    System.out.println("Grade: " + grade);
                    System.out.println("Status: " + (overallAverage >= 60 ? "Passing" : "Failing"));
                    break;

                case 4:
                    System.out.println("Grade tracker closed.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid menu choice. Enter a number from 1 to 4.");
            }
        }

        input.close();
    }
}
