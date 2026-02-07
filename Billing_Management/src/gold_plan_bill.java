public class gold_plan_bill {
    public static void main(String[]args){

        double gold_subscription_price = 20000;
        double discount_percentage = 15;
        double tax_percentage = 20;

        double total_discount = gold_subscription_price * discount_percentage/100;
        double total_tax = gold_subscription_price * tax_percentage/ 100;
        double total_amount =gold_subscription_price +total_tax - total_discount;

        System.out.println("Gold Subscription Bill");
        System.out.println("Basic Plan Price :" + gold_subscription_price);
        System.out.println("Total Discount Amount : " +total_discount );
        System.out.println("Tax Charges : " + total_tax);
        System.out.println("Total Amount : " + total_amount );


    }
}