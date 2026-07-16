package model;

public class PromoCode {

    private String code;
    private double discountPercent;

    public PromoCode(String code, double discountPercent) {
        this.code = code;
        this.discountPercent = discountPercent;
    }

    public String getCode() {
        return code;
    }

    public double getDiscountPercent() {
        return discountPercent;

    }
}