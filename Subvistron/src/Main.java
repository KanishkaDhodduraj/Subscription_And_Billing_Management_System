import model.*;
import service.*;
import service.InvoiceGenerator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Users
        User user = new User(1, "Kanishka", "kani@gmail.com", "12345", Role.USER);
        User admin = new User(1, "Admin", "admin@gmail.com", "67890", Role.ADMIN);

        //Plans

        Plan basic = new Plan(101, "Basic", 299, 30);
        Plan pro = new Plan(102, "Pro", 799, 30);

        //Subscription
        Subscription subscription = new Subscription(user, basic, "ACTIVE");
        PromoCode promo = new PromoCode("WELCOME10", 10);
        PromoService promoService = new PromoService();

        //Billing
        BillingHistoryService billingService = new BillingHistoryService();
        billingService.addRecord(new BillingRecord(1001, 799, "PAID"));
        billingService.addRecord(new BillingRecord(1002, 299, "PAID"));
        billingService.addRecord(new BillingRecord(1003, 299, "PENDING"));

        RevenueService revenueService = new RevenueService();
        RevenueReport report = revenueService.generateRevenue(billingService.getRecords());

        AdminService adminService = new AdminService();
        AuthService auth = new AuthService();

        //Login
        System.out.print("Email : ");
        String email = sc.next();

        System.out.print("Password : ");
        String password = sc.next();

        boolean login = auth.login(admin, email, password);
        if (!login) {
            System.out.println("Invalid Login Credentials");
            return;
        }

        System.out.println("\nLogin Successful");
        //

        AutoRenewService renew = new AutoRenewService();

        int choice;

        do {
            System.out.println("\n     SUBVISTRON     ");

            System.out.println("1.View Subscription");
            System.out.println("2.Upgrade Plan");
            System.out.println("3.Cancel Subscription");
            System.out.println("4.Toggle Auto Renew");
            System.out.println("5.Apply Promo Code");
            System.out.println("6.Billing History");
            System.out.println("7.Revenue Report");
            System.out.println("8.Admin Dashboard");
            System.out.println("9.Generate Invoice");
            System.out.println("10.Make Payment");
            System.out.println("11.Check Expiry");
            System.out.println("12.Run Auto Renewal");
            System.out.println("13.Exit");

            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:

                    subscription.displaySubscription();

                    break;

                case 2:

                    subscription.upgradePlan(pro);

                    break;

                case 3:

                    subscription.cancelSubscription();

                    break;

                case 4:

                    subscription.toggleAutoRenew();

                    break;

                case 5:

                    double finalAmount = promoService.applyPromo(pro.getPrice(), promo);
                    System.out.println ("Final Amount : Rs." + finalAmount);

                    break;

                case 6:

                    billingService.displayHistory();

                    break;

                case 7:

                    report.displayReport();

                    break;

                case 8:

                    adminService.showDashboard(2, 1, 1098);

                    break;

                case 9:
                    String invoiceNo = InvoiceGenerator.generateInvoiceNo();
                    System.out.println("Invoice No. : " + invoiceNo);


                    break;

                case 10:
                    PaymentGateway gateway = new PaymentGateway();
                    gateway.processPayment(pro.getPrice());
                    break;

                case 11:
                    ExpiryChecker checker = new ExpiryChecker();
                    checker.checkExpiry(3);

                    break;

                case 12:

                    subscription.toggleAutoRenew();

                    renew.renewSubscription(subscription.isAutoRenew(), 0);

                    break;

                case 13:
                    System.out.println("Thank You");

                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while(choice != 13);
    }
}