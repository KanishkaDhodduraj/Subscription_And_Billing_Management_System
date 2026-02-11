public class UserSubscription {
    private User user;
    private PlanType planType;
    private String status;
    private String renewalDate;
    private int activeMonths;
    private double totalSpent;

    public UserSubscription(User user, PlanType planType) {
        this.user = user;
        this.planType = planType;
        this.status = "ACTIVE";
        this.renewalDate = "2026-02-10";
        this.activeMonths = 1;
        this.totalSpent = planType.getPrice();
    }

    public void renewSubcription(int months) {
        this.activeMonths += months;
        this.renewalDate = "2026-" + (5 + months) + "-10";
        this.totalSpent += planType.getPrice() * months;
        System.out.println("Your Subscription is Renewed " + months + " months");
    }

    public boolean isExpired() {
        return renewalDate.compareTo("2026-02-10") < 0;
    }
    public void upgradePlan(PlanType newPlan) {
        if (newPlan != null) {
            this.planType = newPlan;

            System.out.println("Upgraded Plan : " + newPlan.name());
        }
    }

    public PlanType getPlanType(){
        return planType;
    }

    public String getStatus()
    {

        return status;
    }

    public void printAssignment() {
        System.out.printf("ID:%d | %s| %-8s| %s%n", user.getId(),user.getName(),planType.name() ,status);
    }


}