import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Customer ID :");
        int id= scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Customer Name :");
        String name = scanner.nextLine();

        System.out.println("Enter Customer Email ID : ");
        String email=scanner.nextLine();

        User user=new User(id,name,email);

        System.out.println("\n Plans : 1.BASIC 2.SILVER 3.GOLD 4.PREMIUM");
        System.out.println("Choose Customer's Plan");
        int choice =scanner.nextInt();
        scanner.nextLine();

        PlanType plan;
        switch(choice){
            case 1: plan=PlanType.BASIC;
            break;
            case 2: plan=PlanType.SILVER;
            break;
            case 3: plan= PlanType.GOLD;
            break;
            case 4 :plan=PlanType.PREMIUM;
            default:
                System.out.println("Invalid! Default: BASIC");
                plan = PlanType.BASIC;

        }

        UserSubscription assignment=new UserSubscription(user,plan,"Active plan");

        assignment.printAssignment();

        scanner.close();

    }
}

