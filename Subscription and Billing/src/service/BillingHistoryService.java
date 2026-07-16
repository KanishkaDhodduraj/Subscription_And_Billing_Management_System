package service;

import model.BillingRecord;
import java.util.ArrayList;

public class BillingHistoryService {

    private ArrayList<BillingRecord> records = new ArrayList<>();

    public void addRecord(BillingRecord record) {
        records.add(record);
    }

    public void displayHistory() {
        System.out.println("\n Billing History ");

        for(BillingRecord record : records) {
            System.out.println("Invoice ID : " + record.getInvoiceId());
            System.out.println("Amount : Rs." + record.getAmount());
            System.out.println("Status : " + record.getPaymentStatus());

        }
    }


    public ArrayList<BillingRecord> getRecords() {
        return records;
    }
}