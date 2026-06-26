import model.*;
import service.*;
import service.InvoiceGenerator;
import dao.UserDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        User admin = new User(1, "Admin", "admin@gmail.com", "12345", Role.ADMIN);
        User user = new User(2, "Kanishka", "kani@gmail.com", "12345", Role.USER);
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


        RegisterService registerService = new RegisterService();
        LoginService loginService = new LoginService();

        //DAO
        UserDAO userDAO = new UserDAO();

        userDAO.viewUsers();

        boolean loginStatus = userDAO.login("admin@gmail.com", "67890");

        System.out.println("Login Status : " + loginStatus);

        //***********************
        int accessChoice;

        System.out.println("\n===== SUBVISTRON =====");
        System.out.println("1. Register");
        System.out.println("2. Login");

        accessChoice = sc.nextInt();

        if (accessChoice == 1) {
            System.out.println("Name : ");
            String name = sc.next();

            System.out.println("Email : ");
            String regEmail = sc.next();

            System.out.println("Password : ");
            String regPassword = sc.next();

            user = new User(2, name, regEmail, regPassword, Role.USER);

            registerService.registerUser(user);

            System.out.println("\nChoose Plan");
            System.out.println("1.Basic - Rs.299");
            System.out.println("2.Pro - Rs.799");

            int planChoice = sc.nextInt();

            Plan selectedPlan;

            if (planChoice == 1) {
                selectedPlan = basic;
            } else {
                selectedPlan = pro;
            }

            PaymentGateway gateway = new PaymentGateway();

            boolean paid = gateway.processPayment(selectedPlan.getPrice());

            if (paid) {

                String invoiceNo = InvoiceGenerator.generateInvoiceNo();

                double amount = selectedPlan.getPrice();

                double gst = amount * 0.18;

                double total = amount + gst;

                Invoice invoice = new Invoice(invoiceNo, user, selectedPlan, amount, gst, total, "UPI", "SUCCESS");

                invoice.displayInvoice();

                subscription = new Subscription(user, selectedPlan, "ACTIVE");
            }
        } else if (accessChoice == 2) {

            System.out.print("Email : ");
            String email = sc.next();

            System.out.print("Password : ");
            String password = sc.next();

            boolean adminLogin = auth.login(admin, email, password);

            boolean userLogin = auth.login(user, email, password);

            if (adminLogin) {
                System.out.println("\nADMIN LOGIN SUCCESS");
            } else if (userLogin) {
                System.out.println("\nUSER LOGIN SUCCESS");
            } else {

                System.out.println("Invalid Login");
                return;
            }
        }

        AutoRenewService renew = new AutoRenewService();


        int userChoice;

        do {


            System.out.println("\n USER DASHBOARD ");

            System.out.println("1. View Subscription");
            System.out.println("2. Upgrade Plan");
            System.out.println("3. Cancel Subscription");
            System.out.println("4. Toggle Auto Renew");
            System.out.println("5. Apply Promo Code");
            System.out.println("6. Billing History");
            System.out.println("7. Generate Invoice");
            System.out.println("8. Make Payment");
            System.out.println("9. Check Expiry");
            System.out.println("10. Run Auto Renewal");
            System.out.println("11. Logout");

            System.out.println("Enter choice : ");
            userChoice = sc.nextInt();

            switch (userChoice) {
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

                    System.out.println("Final Amount : Rs." + finalAmount);
                    break;

                case 6:
                    billingService.displayHistory();
                    break;

                case 7:
                    String invoiceNo = InvoiceGenerator.generateInvoiceNo();

                    double amount = pro.getPrice();
                    double gst = amount * 0.18;
                    double total = amount + gst;

                    Invoice invoice = new Invoice(invoiceNo, user, pro, amount, gst, total, "UPI", "SUCCESS");
                    invoice.displayInvoice();
                    break;

                case 8:
                    PaymentGateway gateway = new PaymentGateway();

                    gateway.processPayment(pro.getPrice());
                    break;

                case 9:
                    ExpiryChecker checker = new ExpiryChecker();
                    checker.checkExpiry(3);
                    break;

                case 10:
                    renew.renewSubscription(subscription.isAutoRenew(), 0);
                    break;

                case 11:
                    System.out.println("Logout Successful");
                    break;

                default:

                    System.out.println(
                            "Invalid Choice"
                    );
            }

        } while (userChoice != 11);


        int adminChoice;

        do {
            System.out.println("\n ADMIN DASHBOARD ");

            System.out.println("1. View Users");
            System.out.println("2. View Revenue");
            System.out.println("3. View Invoices");
            System.out.println("4. View Plans");
            System.out.println("5. View Billing Records");
            System.out.println("6. View Dashboard Analytics");
            System.out.println("7. Logout");

            adminChoice = sc.nextInt();

            switch (adminChoice) {

                case 1:
                    userDAO.viewUsers();
                    break;

                case 2:
                    report.displayReport();
                    break;

                case 3:
                    String invoiceNo = InvoiceGenerator.generateInvoiceNo();

                    System.out.println("Invoice Generated : " + invoiceNo);
                    break;

                case 4:
                    System.out.println("\nAVAILABLE PLANS");

                    System.out.println(basic.getPlanName() + " Rs." + basic.getPrice());

                    System.out.println(pro.getPlanName() + " Rs." + pro.getPrice());
                    break;

                case 5:
                    billingService.displayHistory();
                    break;

                case 6:
                    adminService.showDashboard(2, 1, 1098);
                    break;

                case 7:
                    System.out.println("Logout Successful");
                    break;

                default:

                    System.out.println(
                            "Invalid Choice"
                    );
            }

        } while (adminChoice != 7);

    }
}