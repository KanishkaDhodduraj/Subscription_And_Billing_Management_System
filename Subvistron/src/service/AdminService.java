package service;

public class AdminService {

    public void showDashboard(int users, int subscriptions, double revenue) {

        System.out.println("\n   ADMIN DASHBOARD   ");

        System.out.println("Total Users : " + users);

        System.out.println("Active Subscriptions : " + subscriptions);

        System.out.println("Revenue : Rs." + revenue);
    }
}