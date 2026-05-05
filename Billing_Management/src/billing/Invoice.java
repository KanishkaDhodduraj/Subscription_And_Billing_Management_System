package billing;

public class Invoice {
    private String customerName;
        private String planName;
        private double amount;
        private String date;

        public Invoice(String customerName,String planName,double amount , String date){
            this.customerName=customerName;
            this.planName=planName;
            this.amount =amount;
            this.date=date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPlanName() {
        return planName;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}