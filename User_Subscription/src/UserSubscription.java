public class UserSubscription {
    private User user;
    private PlanType planType;
    private String status;

    public UserSubscription(User user,PlanType planType,String status) {
        this.user =user;
        this.planType=planType;
        this.status=status;
    }


    public PlanType getPlanType(){
        return planType;
    }
    public String getStatus()
    {
        return status;
    }

    public void printAssignment() {
        System.out.println("\n USER DETAILS");
        System.out.println("User ID : " + user.getId());
        System.out.println("User Name : " + user.getName());
        System.out.println("User Email : " + user.getEmail());
        System.out.println("Assigned Plan: " + getPlanType().name());
        System.out.println("Status  : " + getStatus());
    }
}