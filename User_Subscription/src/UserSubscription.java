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
        System.out.printf("ID:%d|%s|%-8s|%s%n", user.getId(),user.getName(),planType.name() ,status);
    }


}