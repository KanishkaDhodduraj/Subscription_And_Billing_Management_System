package service;

public class BillingService {

    public double calculateGST(double amount) {
        return amount * 0.18;
    }

    public double calculateTotal(double amount) {
        return amount + calculateGST(amount);
    }

}