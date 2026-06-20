package model;

public class Payment {

    private int paymentId;
    private double amount;

    public Payment(int paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
    }

    public void processPayment() {

        System.out.println("\nPayment Successful");

        System.out.println("Payment ID : " + paymentId);
        System.out.println("Amount Paid : Rs." + amount);
    }
}