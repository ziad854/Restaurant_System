package System;

import Users.Customer;


public class Billing {

    private FileHandling fileHandler_data;

    public Billing() {
        this.fileHandler_data = new FileHandling("orders");
    }

    public void list() {
        // Read all orders from the file
        Customer customer = new Customer();

        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");

        // Display each order's information
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                String[] orderData = line.split(",");
                int customerId = Integer.parseInt(orderData[1]);//

                String customerInfo = customer.search(customerId);//
                if (customerInfo != null) {
                    String[] customerData = customerInfo.split(",");
                    if (orderData.length == 6) { // Check if the line has all expected data
                        System.out.println("Order ID: " + orderData[0] +
                                ", Customer ID: " + customerId +
                                ", Customer Name: " + customerData[4] +
                                ", Meal Name: " + orderData[2] +
                                ", price: "+orderData[3]+
                                ", Total Amount: " + orderData[4]+
                                ", Total Quantity : " + orderData[5]);
                    } else {
                        System.out.println("Invalid data: " + line);
                    }
                }
            }
        }
    }
    public double getTotalOrderAmount() {
        // Read all orders from the file
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");

        double totalAmount = 0;

        // Sum up the total amount for all orders
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                String[] orderData = line.split(",");
                if (orderData.length == 4) { // Check if the line has all expected data
                    totalAmount += Integer.parseInt(orderData[3]);
                } else {
                    System.out.println("Invalid data: " + line);
                }
            }
        }

        return totalAmount;
    }
}
