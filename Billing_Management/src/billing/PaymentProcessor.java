package billing;

import java.time.LocalDate;
import java.util.Random;

public class PaymentProcessor {

    private static final int MAX_PAYMENTS = 100;

    private static String[] paymentIds = new String[MAX_PAYMENTS];
    private static double[] paymentAmounts = new double[MAX_PAYMENTS];
    private static String[] paymentStatuses = new String[MAX_PAYMENTS];
    private static int paymentCount = 0;


    public static String processPayment(String customerName, String planName, double amount) {

        if (paymentCount >= MAX_PAYMENTS) {
            return "STORAGE_FULL";
        }

        String invoiceId = "INV-" + String.format("%04d", paymentCount + 1000);

        System.out.println("\nPAYMENT PROCESSING");
        System.out.println("Invoice: " + invoiceId);
        System.out.println("Customer: " + customerName);
        System.out.println("Plan: " + planName);
        System.out.println("Amount: ₹" + amount);


        Random rand = new Random();
        int statusCheck = rand.nextInt(100);

        String status;

        if (statusCheck < 80) {
            status = "SUCCESS";
        } else if (statusCheck < 90) {
            status = "PENDING";
        } else {
            status = "FAILED";
        }


        paymentIds[paymentCount] = invoiceId;
        paymentAmounts[paymentCount] = amount;
        paymentStatuses[paymentCount] = status;
        paymentCount++;


        if (status.equals("SUCCESS")) {

            System.out.println("SUCCESS");

            Invoice invoice = new Invoice(
                    customerName,
                    planName,
                    amount,
                    LocalDate.now().toString()
            );

            InvoiceGenerator.generateInvoice(invoice);

        } else {
            System.out.println("FAILED: " + status);
        }

        return invoiceId;
    }


    public static void showAllPayments() {

        System.out.println("\nALL PAYMENTS");

        for (int i = 0; i < paymentCount; i++) {
            System.out.println(
                    paymentIds[i] + " | ₹" + paymentAmounts[i] + " | " + paymentStatuses[i]
            );
        }
    }
}