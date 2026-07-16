package service;

import model.PromoCode;

public class PromoService {

    public double applyPromo(double amount, PromoCode promo) {
        double discount = amount * promo.getDiscountPercent() / 100;

        return amount - discount;
    }
}