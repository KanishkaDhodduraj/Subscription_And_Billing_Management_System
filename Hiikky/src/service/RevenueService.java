package service;

import model.BillingRecord;
import model.RevenueReport;
import java.util.ArrayList;

public class RevenueService {
    public RevenueReport generateRevenue(ArrayList<BillingRecord> records) {

        double totalRevenue = 0;

        for(BillingRecord record : records) {

            if(record.getPaymentStatus().equalsIgnoreCase("PAID")) {
                totalRevenue += record.getAmount();
            }
        }

        return new RevenueReport(totalRevenue);
    }
}