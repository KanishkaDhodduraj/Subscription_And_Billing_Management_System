public class PaymentProcessor {

        private static final int MAX_PAYMENTS = 100;
        private static String[] paymentIds = new String[MAX_PAYMENTS];
        private static double[] paymentAmounts = new double[MAX_PAYMENTS];
        private static String[] paymentStatuses = new String[MAX_PAYMENTS];
        private static int paymentCount = 0;

        // Process payment using control flow
        public static String processPayment(UserSubscription sub, double amount, String method) {
            if (paymentCount >= MAX_PAYMENTS) {
                return "STORAGE_FULL";
            }

           //string concatenation
            String invoiceId = "INV-" + String.format("%04d", paymentCount + 1000);

            System.out.println("\n💳 PAYMENT PROCESSING");
            System.out.println("Invoice: " + invoiceId);
            System.out.println("User: " + sub.getUser().getName());
            System.out.println("Amount: ₹" + amount);

            // Control flow for payment success (80% success)
            String status;
            boolean success = false;
            double randomCheck = Math.random() * 100;

            if (randomCheck < 80) {
                success = true;
                status = "SUCCESS";
            } else if (randomCheck < 90) {
                status = "PENDING";
            } else {
                status = "FAILED";
            }

            // Store in arrays using control flow
            paymentIds[paymentCount] = invoiceId;
            paymentAmounts[paymentCount] = amount;
            paymentStatuses[paymentCount] = status;
            paymentCount++;

            if (success) {
                // Update subscription total
                double newTotal = sub.getTotalSpent() + amount;
                sub.setTotalSpent(newTotal);
                System.out.println("SUCCESS | New Balance: ₹" + newTotal);
            } else {
                System.out.println("FAILED: " + status);
            }

            return invoiceId;
        }

        // Revenue report using array loops
        public static void generateRevenueReport(UserSubscription[] subscriptions, int userCount) {
            double totalRevenue = 0;
            int activeUsers = 0;

            System.out.println("\n REVENUE DASHBOARD");


            // Loop through array with control flow
            for (int i = 0; i < userCount; i++) {
                UserSubscription sub = subscriptions[i];

                // String comparison control flow
                if (sub.getStatus().equals("ACTIVE")) {
                    double monthlyRevenue = sub.getPlanType().getPrice();
                    totalRevenue += monthlyRevenue;
                    activeUsers++;

                    // String formatting
                    String line = String.format("ID:%d | %-10s | %-7s | ₹%.0f/mo",
                            sub.getUser().getId(),
                            sub.getUser().getName(),
                            sub.getPlanType().name(),
                            monthlyRevenue);
                    System.out.println(line);
                }
            }

            // Final calculations with strings
            String summary = String.format("ACTIVE: %d users | ₹%.0f/month", activeUsers, totalRevenue);

            System.out.println(summary);
        }

        // Upgrade with payment validation
        public static boolean upgradeWithPayment(UserSubscription sub, PlanType newPlan) {
            double oldPrice = sub.getPlanType().getPrice();
            double newPrice = newPlan.getPrice();
            double priceDiff = newPrice - oldPrice;

            // Control flow validation
            if (priceDiff <= 0) {
                System.out.println(" Cannot downgrade!");
                return false;
            }

            // Process payment
            String invoice = processPayment(sub, priceDiff, "CREDIT_CARD");

            // String validation
            if (invoice.startsWith("INV-") && paymentStatuses[paymentCount-1].equals("SUCCESS")) {
                sub.upgradePlan(newPlan);
                System.out.println(" UPGRADED: " + newPlan.name());
                return true;
            }
            return false;
        }

        // Search payments by user ID using array loop
        public static void searchPayments(int userId) {
            System.out.println("\n PAYMENTS FOR USER ID: " + userId);
            boolean found = false;

            // Array search with control flow
            for (int i = 0; i < paymentCount; i++) {
                UserSubscription sub = getSubscriptionByPayment(paymentIds[i]); // Assume helper
                if (sub != null && sub.getUser().getId() == userId) {
                    String status = paymentStatuses[i].equals("SUCCESS") ? "Yes" : "No";
                    System.out.println(paymentIds[i] + " | ₹" + paymentAmounts[i] + " | " + status);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No payments found");
            }
        }
    }

}
