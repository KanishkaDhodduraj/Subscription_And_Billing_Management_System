package billing;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InvoiceGenerator {

    public static void generateInvoice(Invoice invoice) {

        String folderPath = "invoices";
        File folder = new File(folderPath);

        // ✅ CREATE FOLDER IF NOT EXISTS
        if (!folder.exists()) {
            folder.mkdir();
        }

        String fileName = folderPath + "/" + invoice.getCustomerName() + "_invoice.txt";

        try {
            FileWriter writer = new FileWriter(fileName);

            writer.write("==== INVOICE ====\n");
            writer.write("Customer: " + invoice.getCustomerName() + "\n");
            writer.write("Plan: " + invoice.getPlanName() + "\n");
            writer.write("Amount: ₹" + invoice.getAmount() + "\n");
            writer.write("Date: " + invoice.getDate() + "\n");
            writer.write("=================\n");

            writer.close();

            System.out.println("Invoice generated: " + fileName);

        } catch (IOException e) {
            System.out.println("Error in the invoice");
            e.printStackTrace();
        }
    }
}