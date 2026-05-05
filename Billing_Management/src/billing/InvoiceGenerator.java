package billing;

import java.io.FileWriter;
import java.io.IOException;

public class InvoiceGenerator {
    public static void generateInvoice(Invoice invoice){
        String filename = "invoices/" + invoice.getCustomerName()+"_invoice.txt";

        try{
            FileWriter writer = new FileWriter((filename));
            writer.write("INVOICE\n");

            writer.write("Customer Name :" + invoice.getCustomerName()+"\n");
            writer.write("Plan Name :" + invoice.getPlanName()+"\n");
            writer.write("Amount Paid :" + invoice.getAmount()+"\n");
            writer.write("Date :" + invoice.getDate()+"\n");

            writer.write("Thankyou\n");

            writer.close();

            System.out.println("Invoice is generated"+filename);

        } catch (IOException e){

            System.out.println("Error in the invoice");
            e.printStackTrace();
        }


    }
}
