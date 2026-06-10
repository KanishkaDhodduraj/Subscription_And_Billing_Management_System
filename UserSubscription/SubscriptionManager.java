import java.util.Scanner;

public class SubscriptionManager {
    private static UserSubscription[] subscriptions = new UserSubscription[100];
    private static int userCount = 0;

    public static void main(String[] args) {

        System.out.println("SUBSCRIPTION SYSTEM");
        Scanner scanner = new Scanner(System.in);

        subscriptions[userCount++] = new UserSubscription(new User(101, "Kanishka", "kanishka@email.com"), PlanType.SILVER);
        subscriptions[userCount++] = new UserSubscription(new User(102, "Reenu", "reenu@email.com"), PlanType.BASIC);

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();

            switch(choice) {
                case 1: testUsageTracking(); break;
                case 2: updateAllRenewals(); break;
                case 3: printAllSubscriptions(); break;
                case 0: System.out.println("Thank you"); break;
            }
        } while(choice != 0);
        scanner.close();
    }

    public static void testUsageTracking() {
        UsageTracker.addUsage(subscriptions[0], 60);
        subscriptions[0].renewSubscription(3);
        subscriptions[0].printAssignment();

        UsageTracker.addUsage(subscriptions[1], 8);
        subscriptions[1].printAssignment();
    }

    public static void updateAllRenewals() {
        System.out.println("\n RENEWALS UPDATE:");
        double totalRevenue = 0;

        for(int i = 0; i < userCount; i++) {
            subscriptions[i].updateRenewals();
            totalRevenue += subscriptions[i].getTotalSpent();  // FIXED!
            subscriptions[i].printAssignment();
        }
        System.out.println(" Revenue: ₹" + totalRevenue);
    }

    public static void printAllSubscriptions() {
        System.out.println("\n SUBSCRIPTIONS:");
        for(int i = 0; i < userCount; i++) {
            subscriptions[i].printAssignment();
        }
    }

    public static void showMenu() {
        System.out.println("\n1. Test Usage\n2. Update Renewals\n3. Show All\n0. Exit");
        System.out.print("Choose: ");
    }
}
