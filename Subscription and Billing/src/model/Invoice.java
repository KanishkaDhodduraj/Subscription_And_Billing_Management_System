package model;

public class Invoice {
    private String invoiceNo;
    private User user;
    private Plan plan;
    private double amount;
    private double gst;
    private double totalAmount;
    private String paymentMethod;
    private String paymentStatus;

    public Invoice(String invoiceNo, User user, Plan plan, double amount, double gst, double totalAmount, String paymentMethod, String paymentStatus) {

        this.invoiceNo = invoiceNo;
        this.user = user;
        this.plan = plan;
        this.amount = amount;
        this.gst = gst;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }
    public void displayInvoice() {
        System.out.println("Invoice No. : " + invoiceNo);
        System.out.println("\nCUSTOMER DETAILS");
        System.out.println("User ID : " + user.getUserId());
        System.out.println("Name    : " + user.getName());
        System.out.println("Email   : " + user.getEmail());

        System.out.println("\nPLAN DETAILS");
        System.out.println("Plan ID   : " + plan.getPlanId());
        System.out.println("Plan Name : " + plan.getPlanName());
        System.out.println("Price     : Rs." + plan.getPrice());

        System.out.println("\nPAYMENT DETAILS");
        System.out.println("Method : " + paymentMethod);
        System.out.println("Status : " + paymentStatus);

        System.out.println("\nAMOUNT DETAILS");
        System.out.println("Amount : Rs." + amount);
        System.out.println("GST    : Rs." + gst);
        System.out.println("Total  : Rs." + totalAmount);

    }
}