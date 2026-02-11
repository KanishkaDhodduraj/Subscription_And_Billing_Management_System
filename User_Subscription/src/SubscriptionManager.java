public class SubscriptionManager{
    public static void main(String[] args){


        User user1 =new User(101, "Kanishka", "kanishka@email.com");
        User user2 =new User(102, "Reenu", "reenu@email.com");

        UserSubscription sub1=new UserSubscription(user1,PlanType.GOLD);
        UserSubscription sub2=new UserSubscription(user2,PlanType.SILVER);

        sub1.renewSubcription(3);
        sub2.upgradePlan(PlanType.GOLD);

        sub1.printAssignment();
        sub2.printAssignment();

        System.out.println("Revenue : " +(sub1.isExpired()? 0 : 999)+" per months");

    }
}