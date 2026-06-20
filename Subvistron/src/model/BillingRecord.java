package model;

public class BillingRecord {

    private int invoiceId;
    private double amount;
    private String paymentStatus;

    public BillingRecord(int invoiceId, double amount, String paymentStatus) {
        this.invoiceId = invoiceId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
}