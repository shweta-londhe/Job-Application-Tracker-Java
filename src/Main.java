import dao.JobDAO;
import model.JobApplication;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        JobDAO dao = new JobDAO();

        while (true) {
            System.out.println("\n===== Job Tracker Menu =====");
            System.out.println("1. Add Job");
            System.out.println("2. View All Jobs");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Company Name: ");
                    String company = sc.nextLine();

                    System.out.print("Enter Role: ");
                    String role = sc.nextLine();

                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();

                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();

                    System.out.print("Enter Notes: ");
                    String notes = sc.nextLine();

                    JobApplication job = new JobApplication(
                            company,
                            role,
                            status,
                            Date.valueOf(date),
                            notes
                    );

                    dao.addJob(job);
                    break;

                case 2:
                    dao.viewAllJobs();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}