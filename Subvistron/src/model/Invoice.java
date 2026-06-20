package model;

public class Invoice {

    private int invoiceId;
    private double amount;
    private double gst;
    private double total;

    public Invoice(int invoiceId, double amount) {
        this.invoiceId = invoiceId;
        this.amount = amount;

        gst = amount * 0.18;
        total = amount + gst;

    }

    public void printInvoice() {

        System.out.println("\nInvoice");

        System.out.println("Invoice ID : " + invoiceId);
        System.out.println("Amount : Rs." + amount);
        System.out.println("GST : Rs." + gst);
        System.out.println("Total : Rs." + total);
    }
}