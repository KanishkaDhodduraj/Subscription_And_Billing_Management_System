public class SubscriptionManager {
    private static UserSubscription[] subscriptions = new UserSubscription[100];
    private static int userCount = 0;

    public static void main(String[] args) {
        System.out.println("SUBSCRIPTION & USAGE BILLING SYSTEM ");

        subscriptions[userCount++] = new UserSubscription(new User(101, "Kanishka", "kanishka@email.com"), PlanType.SILVER);
        subscriptions[userCount++] = new UserSubscription(new User(102, "Reenu", "reenu@email.com"), PlanType.BASIC);

        testUsageTracking();

        UsageTracker.generateUsageReport(subscriptions, userCount);

    }
    public static void testUsageTracking() {
        System.out.println("TESTING USAGE TRACKING:");

        //Kanishka heavy usage -> Needs GOLD
        UsageTracker.addUsage(subscriptions[0], 60);  // SILVER → GOLD recommendation
        subscriptions[0].renewSubcription(3);
        subscriptions[0].printAssignment();

        //Reenu light usage ->OK on BASIC
        UsageTracker.addUsage(subscriptions[1], 8);   // Stays BASIC
        subscriptions[1].printAssignment();
    }
}