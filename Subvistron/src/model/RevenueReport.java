package model;

public class RevenueReport {

    private double totalRevenue;

    public RevenueReport(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public void displayReport() {
        System.out.println("\n      Revenue Report      ");
        System.out.println("Total Revenue : Rs." + totalRevenue);
    }
}