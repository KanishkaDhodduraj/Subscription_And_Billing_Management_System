package service;

public class EmailService {

    public void sendInvoice(String email, String invoiceNo) {

        System.out.println("\nEmail Sent To : " + email);

        System.out.println("Invoice : "+ invoiceNo);
    }

    public void sendExpiryReminder(String email, int daysLeft) {

        System.out.println("\nReminder Email Sent");

        System.out.println("To : " + email);

        System.out.println("Subscription expires in " + daysLeft + " days"
        );

    }
}