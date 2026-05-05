package billing;

public class MainBilling {

    public static void main(String[] args) {

        PaymentProcessor.processPayment("Kanishka", "Premium Plan", 499);

        PaymentProcessor.processPayment("Rahul", "Basic Plan", 199);

        PaymentProcessor.showAllPayments();
    }
}