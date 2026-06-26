package service;

import java.util.Random;

public class PaymentGateway {
    public boolean processPayment(double amount) {

        Random random = new Random();
        int paymentStatus = random.nextInt(100);

        if(paymentStatus < 80) {
            System.out.println("\nPayment Successful");

            System.out.println("Amount Paid : Rs." + amount);
            return true;
        }

        System.out.println("\nPayment Failed");
        return false;

    }
}