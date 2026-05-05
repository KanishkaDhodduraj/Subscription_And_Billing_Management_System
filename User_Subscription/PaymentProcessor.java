package billing;

import User_Subscription.UserSubscription;
import User_Subscription.PlanType;

import billing.Invoice;
import billing.InvoiceGenerator;

import java.time.LocalDate;

public class PaymentProcessor {

    private static final int MAX_PAYMENTS = 100;

    private static String[] paymentIds = new String[MAX_PAYMENTS];
    private static double[] paymentAmounts = new double[MAX_PAYMENTS];
    private static String[] paymentStatuses = new String[MAX_PAYMENTS];
    private static int[] paymentUserIds = new int[MAX_PAYMENTS]; // ✅ track user
    private static int paymentCount = 0;

    // ✅ PROCESS PAYMENT
    public static String processPayment(UserSubscription sub, double amount, String method) {

        if (paymentCount >= MAX_PAYMENTS) {
            return "STORAGE_FULL";
        }

        String invoiceId = "INV-" + String.format("%04d", paymentCount + 1000);

        System.out.println("\nPAYMENT PROCESSING");
        System.out.println("Invoice: " + invoiceId);
        System.out.println("User: " + sub.getUser().getName());
        System.out.println("Amount: ₹" + amount);

        // ✅ payment logic
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

        // ✅ store data
        paymentIds[paymentCount] = invoiceId;
        paymentAmounts[paymentCount] = amount;
        paymentStatuses[paymentCount] = status;
        paymentUserIds[paymentCount] = sub.getUser().getId(); // ✅ link user
        paymentCount++;

        // ✅ SUCCESS FLOW
        if (success) {
            double newTotal = sub.getTotalSpent() + amount;
            sub.setTotalSpent(newTotal);

            System.out.println("SUCCESS | New Balance: ₹" + newTotal);

            // ✅ INVOICE GENERATION
            Invoice invoice = new Invoice(
                    sub.getUser().getName(),
                    sub.getPlanType().name(),
                    amount,
                    LocalDate.now().toString()
            );

            InvoiceGenerator.generateInvoice(invoice);

        } else {
            System.out.println("FAILED: " + status);
        }

        return invoiceId;
    }

    // ✅ REVENUE REPORT
    public static void generateRevenueReport(UserSubscription[] subscriptions, int userCount) {

        double totalRevenue = 0;
        int activeUsers = 0;

        System.out.println("\nREVENUE DASHBOARD");

        for (int i = 0; i < userCount; i++) {
            UserSubscription sub = subscriptions[i];

            if (sub.getStatus().equals("ACTIVE")) {

                double monthlyRevenue = sub.getPlanType().getPrice();
                totalRevenue += monthlyRevenue;
                activeUsers++;

                String line = String.format(
                        "ID:%d | %-10s | %-7s | ₹%.0f/mo",
                        sub.getUser().getId(),
                        sub.getUser().getName(),
                        sub.getPlanType().name(),
                        monthlyRevenue
                );

                System.out.println(line);
            }
        }

        String summary = String.format(
                "ACTIVE: %d users | ₹%.0f/month",
                activeUsers,
                totalRevenue
        );

        System.out.println(summary);
    }

    // ✅ UPGRADE WITH PAYMENT
    public static boolean upgradeWithPayment(UserSubscription sub, PlanType newPlan) {

        double oldPrice = sub.getPlanType().getPrice();
        double newPrice = newPlan.getPrice();
        double priceDiff = newPrice - oldPrice;

        if (priceDiff <= 0) {
            System.out.println("Cannot downgrade!");
            return false;
        }

        String invoice = processPayment(sub, priceDiff, "CREDIT_CARD");

        if (invoice.startsWith("INV-") &&
                paymentStatuses[paymentCount - 1].equals("SUCCESS")) {

            sub.upgradePlan(newPlan);
            System.out.println("UPGRADED: " + newPlan.name());
            return true;
        }

        return false;
    }

    // ✅ SEARCH PAYMENTS (FIXED)
    public static void searchPayments(int userId) {

        System.out.println("\nPAYMENTS FOR USER ID: " + userId);
        boolean found = false;

        for (int i = 0; i < paymentCount; i++) {

            if (paymentUserIds[i] == userId) {

                String status = paymentStatuses[i].equals("SUCCESS") ? "Yes" : "No";

                System.out.println(
                        paymentIds[i] + " | ₹" + paymentAmounts[i] + " | Paid: " + status
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("No payments found");
        }
    }
}