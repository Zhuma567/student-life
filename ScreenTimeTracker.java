import java.util.Scanner;

public class ScreenTimeTracker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int socialMediaTime = 0;
        int gamingTime = 0;
        int studyingTime = 0;
        int streamingTime = 0;
        int totalScreenTime = 0;
        int recordedSessions = 0;

        boolean running = true;

        while (running) {
            System.out.println("\n===== SCREEN-TIME TRACKER =====");
            System.out.println("1. Add social media time");
            System.out.println("2. Add gaming time");
            System.out.println("3. Add studying time");
            System.out.println("4. Add video or streaming time");
            System.out.println("5. View statistics");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid menu choice. Enter a number from 1 to 6.");
                input.next();
                continue;
            }

            int choice = input.nextInt();

            if (choice >= 1 && choice <= 4) {
                String category;
                switch (choice) {
                    case 1: category = "social media"; break;
                    case 2: category = "gaming"; break;
                    case 3: category = "studying"; break;
                    default: category = "video or streaming"; break;
                }

                System.out.print("Enter " + category + " minutes: ");
                if (!input.hasNextInt()) {
                    System.out.println("Invalid time. Minutes must be a positive whole number.");
                    input.next();
                    continue;
                }

                int minutes = input.nextInt();
                if (minutes <= 0) {
                    System.out.println("Invalid time. Minutes must be greater than 0.");
                    continue;
                }

                switch (choice) {
                    case 1: socialMediaTime += minutes; break;
                    case 2: gamingTime += minutes; break;
                    case 3: studyingTime += minutes; break;
                    case 4: streamingTime += minutes; break;
                    default: break;
                }

                totalScreenTime += minutes;
                recordedSessions++;
                System.out.println("Time added successfully!");

            } else if (choice == 5) {
                int entertainmentTime = socialMediaTime + gamingTime + streamingTime;

                System.out.println("\n===== TODAY'S SCREEN TIME =====");
                System.out.println("Social media: " + socialMediaTime + " minutes");
                System.out.println("Gaming: " + gamingTime + " minutes");
                System.out.println("Studying: " + studyingTime + " minutes");
                System.out.println("Streaming: " + streamingTime + " minutes");
                System.out.println("Total screen time: " + totalScreenTime + " minutes");
                System.out.println("Recorded sessions: " + recordedSessions);

                if (studyingTime > entertainmentTime) {
                    System.out.println("Study screen time is greater than entertainment screen time. Good balance!");
                } else if (studyingTime < entertainmentTime) {
                    System.out.println("Entertainment screen time is greater than study time.");
                } else {
                    System.out.println("Study and entertainment screen time are equal.");
                }

                if (totalScreenTime < 120) {
                    System.out.println("Low screen time");
                } else if (totalScreenTime <= 240) {
                    System.out.println("Moderate screen time");
                } else {
                    System.out.println("High screen time");
                }

            } else if (choice == 6) {
                System.out.println("Screen-time tracker closed.");
                running = false;
            } else {
                System.out.println("Invalid menu choice. Enter a number from 1 to 6.");
            }
        }

        input.close();
    }
}
