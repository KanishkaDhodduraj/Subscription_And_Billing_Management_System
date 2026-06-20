package service;
import model.Payment;

public class PaymentService {

    public void makePayment(Payment payment) {
        payment.processPayment();

    }
}