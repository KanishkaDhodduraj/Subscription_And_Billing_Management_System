public class premium_plan_bill {
    public static void main(String[] args){
        double premium_subscription_price = 25000;
        double discount_percentage = 25;
        double tax_percentage = 20;

        double total_discount = premium_subscription_price * discount_percentage/100;
        double total_tax = premium_subscription_price * tax_percentage/ 100;
        double total_amount =premium_subscription_price +total_tax - total_discount;

        System.out.println("Premium Subscription Bill");
        System.out.println("Basic Plan Price :" + premium_subscription_price);
        System.out.println("Total Discount Amount : " +total_discount );
        System.out.println("Tax Charges : " + total_tax);
        System.out.println("Total Amount : " + total_amount );


    }
}
