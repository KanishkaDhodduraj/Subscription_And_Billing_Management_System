class basic_plan_bill{
    public static void main(String[] args) {

        double basic_subscription_price = 10000;
        double discount_percentage = 5;
        double tax_percentage = 10;

        double total_discount = basic_subscription_price * discount_percentage / 100;
        double total_tax = basic_subscription_price * tax_percentage / 100;
        double total_amount = basic_subscription_price + total_tax - total_discount;

            System.out.println("Basic Subscription Bill");
            System.out.println("Basic Plan Price :" + basic_subscription_price);
            System.out.println("Total Discount Amount : " + total_discount);
            System.out.println("Tax Charges : " + total_tax);
            System.out.println("Total Amount : " + total_amount);

        }
    }