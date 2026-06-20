package service;

import model.Subscription;
import java.util.ArrayList;

public class SubscriptionService {
    private ArrayList<Subscription> subscriptions = new ArrayList<>();

    public void subscribe(Subscription subscription) {
        subscriptions.add(subscription);
        System.out.println(" \nSubscription Activated ");
    }

    public void displaySubscriptions() {
        for(Subscription s : subscriptions) {
            s.displaySubscription();
        }
    }
}