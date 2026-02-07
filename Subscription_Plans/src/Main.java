import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Create Subscription Plan ===");

        System.out.print("Enter Plan ID: ");
        int planId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Plan Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Monthly Price: ");
        double pricePerMonth = scanner.nextDouble();

        System.out.print("Enter Duration (in months): ");
        int durationInMonths = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        System.out.println("\n=== Plan Created Successfully ===");
        System.out.println("ID          : " + planId);
        System.out.println("Name        : " + name);
        System.out.println("Price/Month : " + pricePerMonth);
        System.out.println("Duration    : " + durationInMonths + " months");
        System.out.println("Description : " + description);

        scanner.close();
    }
}
