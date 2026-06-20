package service;

import model.BillingRecord;
import model.RevenueReport;
import java.util.ArrayList;

public class RevenueService {
    public RevenueReport generateRevenue(ArrayList<BillingRecord> records) {

        double total = 0;

        for(BillingRecord record : records) {

            if(record.getPaymentStatus().equalsIgnoreCase("PAID")) {
                total += record.getAmount();
            }
        }

        return new RevenueReport(total);
    }
}