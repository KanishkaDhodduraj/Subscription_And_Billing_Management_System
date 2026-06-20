package model;

public class Subscription {

    private User user;
    private Plan plan;
    private String status;
    private boolean autoRenew;

    public Subscription(User user, Plan plan, String status) {

        this.user = user;
        this.plan = plan;
        this.status = status;
        this.autoRenew = true;
    }

    public void upgradePlan(Plan newPlan) {
        this.plan = newPlan;

        System.out.println("Plan Upgraded to : " + newPlan.getPlanName());
    }

    public void cancelSubscription() {
        status = " CANCELLED ";
        System.out.println("Subscription Cancelled");
    }

    public void toggleAutoRenew() {
        autoRenew = !autoRenew;

        System.out.println("Auto Renewal : " + autoRenew);
    }


    public void displaySubscription() {

        System.out.println("\nSubscription Details");


        System.out.println("User Name : " + user.getName());

        System.out.println("Plan : " + plan.getPlanName());

        System.out.println("Status : " + status);

        System.out.println("Auto Renewal : " + autoRenew);
    }
}