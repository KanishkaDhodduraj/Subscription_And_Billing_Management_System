public class UserSubscription {
    private User user;
    private PlanType planType;
    private String status;
    private String renewalDate;
    private int activeMonths;
    private double totalSpent;
    private int usageUnits = 0;

    public UserSubscription(User user,PlanType planType) {
        this.user = user;
        this.planType = planType;
        this.status = "ACTIVE";
        this.renewalDate = "2026-02-10";
        this.activeMonths = 1;
        this.totalSpent = planType.getPrice();
        this.usageUnits = 0;
    }

    public void renewSubscription(int months) {
        this.activeMonths += months;
        this.status = "ACTIVE";
        this.totalSpent += planType.getPrice() * months;
        System.out.println("  " + user.getName() + " renewed " + months + " months!");
    }

    public boolean isExpired() {

        //if activemonths <= 0 is, expired

        if(activeMonths <= 0) {
            status = "EXPIRED";
            return true;
        }
        return false;
    }
    public void updateRenewals() {
        if(activeMonths <= 0) {
            status = "EXPIRED";
            System.out.println(" " + user.getName() + " EXPIRED!");
        } else {
            activeMonths--;
            System.out.println(" " + user.getName() + " - " + activeMonths + " months left");
        }
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void upgradePlan(PlanType newPlan) {
        if (newPlan != null) {
            this.planType = newPlan;
            System.out.println("Upgraded Plan : " + newPlan.name());
        }
    }

    public User getUser() {
        return user;
    }


    public PlanType getPlanType() {
        return planType;
    }

    public String getStatus() {
        return status;
    }

    public int getUsageUnits() {
        return usageUnits;
    }

    public void setUsageUnits(int units) {
        this.usageUnits = units;
    }

    public void printAssignment() {
        System.out.printf("ID:%d | %-10s | %-8s | %s | Usage: %d units | ₹%.0f total%n",
                user.getId(), user.getName(), planType.name(), status, usageUnits, totalSpent);
    }

    public int getActiveMonths() {
        return activeMonths;
    }

    public void setActiveMonths(int activeMonths) {
        this.activeMonths = activeMonths;
    }
}