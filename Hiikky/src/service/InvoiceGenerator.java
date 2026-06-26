package service;

public class InvoiceGenerator {

    private static int counter = 1;

    public static String generateInvoiceNo() {
        return " INV-2026- " + String.format("%04d", counter++);
    }
}