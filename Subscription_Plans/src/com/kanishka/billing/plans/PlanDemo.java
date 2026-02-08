package com.kanishka.billing.plans;

public class PlanDemo {
    public static void main(String[] args) {

        PlanType currentPlan = PlanType.BASIC;

        System.out.println("Subscription Details");
        System.out.println("Plan Type : " + currentPlan);

        switch (currentPlan) {
            case BASIC:
                System.out.println("Plan Name      : Basic");
                System.out.println("Plan Id        : 001");
                System.out.println("Plan Duration  : 3 months");
                System.out.println("Cost           : 10000");
                System.out.println("The Basic plan is for individual users or very small teams who are just starting.");
                System.out.println("It usually includes one active subscription, simple billing with tax and discount, and a single payment method.");
                System.out.println("This plan focuses on essential features without pause/resume or advanced reports.");
                System.out.println("Features : Simple billing, 1 active subscription");
                break;

            case SILVER:
                System.out.println("Plan Name      : Silver");
                System.out.println("Plan Id        : 002");
                System.out.println("Plan Duration  : 6 months");
                System.out.println("Cost           : 15000");
                System.out.println("The Silver plan is for customers who need a bit more control than Basic.");
                System.out.println("It can allow multiple active subscriptions, the ability to pause and resume a subscription, and basic trial support.");
                System.out.println("Silver is a good choice for small businesses that are growing and need more flexibility.");
                System.out.println("Features : Includes pause and resume");
                break;

            case GOLD:
                System.out.println("Plan Name      : Gold");
                System.out.println("Plan Id        : 003");
                System.out.println("Plan Duration  : 8 months");
                System.out.println("Cost           : 20000");
                System.out.println("The Gold plan targets serious business users.");
                System.out.println("It includes all Silver features plus easy plan changes (upgrade/downgrade), better limits, and improved billing history.");
                System.out.println("This plan is suitable for companies that manage many customers and need smooth subscription management.");
                System.out.println("Features : Pause/resume, change plan, multiple subscriptions");
                break;

            case PREMIUM:
                System.out.println("Plan Name      : Premium");
                System.out.println("Plan Id        : 004");
                System.out.println("Plan Duration  : 12 months");
                System.out.println("Cost           : 25000");
                System.out.println("The Premium plan is designed for advanced or enterprise users.");
                System.out.println("It provides everything in Gold plus priority support, detailed reports, and flexible limits on subscriptions and payments.");
                System.out.println("Features : All features, priority support");
                break;
        }
    }
}