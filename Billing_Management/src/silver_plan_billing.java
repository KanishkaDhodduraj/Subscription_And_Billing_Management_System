public class silver_plan_billing {
    public static void main(String[] args){

        double silver_subscription_price = 15000;
        double discount_percentage = 10;
        double tax_percentage = 15;

        double total_discount = silver_subscription_price * discount_percentage/100;
        double total_tax = silver_subscription_price * tax_percentage/ 100;
        double total_amount =silver_subscription_price +total_tax - total_discount;

        System.out.println("Silver Subscription Bill");
        System.out.println("Basic Plan Price :" + silver_subscription_price);
        System.out.println("Total Discount Amount : " +total_discount );
        System.out.println("Tax Charges : " + total_tax);
        System.out.println("Total Amount : " + total_amount );
    }
}