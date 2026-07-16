package service;

public class AutoRenewService {

    public void renewSubscription(boolean autoRenew, int remainingDays) {

        if(autoRenew && remainingDays <= 0) {
            System.out.println("Subscription Renewed");
        }

        else if(!autoRenew && remainingDays <= 0) {
            System.out.println("Subscription Expired");
        }

        else {
            System.out.println("Subscription Active");
        }
    }
}