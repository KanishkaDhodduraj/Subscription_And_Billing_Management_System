public class SubscriptionManager{
    public static void main(String[] args){
        System.out.println(" Multiple Users");

        User user1 =new User(101, "Kanishka", "kanishka@email.com");
        User user2 =new User(102, "Reenu", "reenu@email.com");

        UserSubscription sub1=new UserSubscription(user1,PlanType.GOLD,"ACTIVE");
        UserSubscription sub2=new UserSubscription(user2,PlanType.SILVER,"ACTIVE");


        sub1.printAssignment();
        sub2.printAssignment();

        System.out.println("\n Successfully 2 users are assigned.");
    }
}