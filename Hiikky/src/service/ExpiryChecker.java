package service;

public class ExpiryChecker {

    public void checkExpiry(
            int remainingDays) {

        if(remainingDays <= 0) {
            System.out.println("Subscription Expired");
        }

        else if(remainingDays <= 10) {
            System.out.println("Subscription Expiring Soon");
            System.out.println("Remaining Days : " + remainingDays);
        }

        else {
            System.out.println("Subscription Active");
            System.out.println("Remaining Days : " + remainingDays);
        }

    }
}