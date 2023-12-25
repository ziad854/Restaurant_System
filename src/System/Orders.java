package System;

import Users.Customer;
import java.lang.reflect.Field;

public class Orders extends User {

    private int id;
    private int customerId;
    private int totalAmount;
    private int quantity;
    private String mealName;
    private static int nextId = 1;
    private static FileHandling fileHandler_data;

    public Orders() {
        fileHandler_data = new FileHandling("orders");
    }

    public void setId() {
        String filecontent = fileHandler_data.ReadFile();
        String[] lines = filecontent.split("\n");
        if (filecontent.isEmpty()) {
            this.id = nextId;
        } else {

            String[] customerData = lines[lines.length - 1].split(",");
            this.id = (Integer.parseInt(customerData[0])) + 1;
        }
    }

    public void setMealName(String mealName) {

        this.mealName = mealName;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
    public void setQuantitiy(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getMealName() {
        return mealName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
    public int getQuantitiy() {
        return quantity;
    }


    public boolean makeOrder(Orders order) {

        String orderData = order.getId() + "," + order.getCustomerId() + "," + order.getMealName() +"," + (order.getTotalAmount() ) +"," + (order.getTotalAmount()*order.getQuantitiy() )+ "," + order.getQuantitiy();
        return fileHandler_data.WriteToFile(orderData);
    }

    public boolean CanelOrder(int orderId,int id_Cus) {
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");
        boolean check=false;
        String updatedContent = "";

        // Find and remove the customer with the given ID
        for (String line : lines) {
            String[] orderData = line.split(",");
            if (orderData[0].equals(Integer.toString(orderId)) && orderData[1].equals(Integer.toString(id_Cus))) {
                check=true;
            }
            else if(!orderData[0].equals(Integer.toString(orderId)) || !orderData[1].equals(Integer.toString(id_Cus)))
            {
                updatedContent += line + "\n";

            }

        }
        fileHandler_data.updatesToFile(updatedContent);
        // Write the updated content back to the file
        return check;
    }

    public boolean list(int id) {
        // Read all customers from the file
        Customer customer = new Customer();
        boolean c = false;

        if (customer.search(id) != null) {
            String[] customerData = customer.search(id).split(",");
            String fileContent = fileHandler_data.ReadFile();
            String[] lines = fileContent.split("\n");
            // Display each customer's information
            for (String line : lines) {
                if (!line.trim().isEmpty()) {
                    String[] orderData = line.split(",");
                    if (id == Integer.parseInt(orderData[1])) {
                        if (orderData.length == 6) { // Check if the line has all expected dat
                            System.out.println("ID: " + orderData[0] + ", Customer Name: " + customerData[1] + ", Meal Name: " + orderData[2] + ", Meal Price" + orderData[3] + ", Total price: " + orderData[4] + ", Total Quantity: " + orderData[5]);
                            c = true;
                        } else {
                            System.out.println("Invalid data: " + line);
                        }
                    }
                }
            }
        } else {
            c = false;
        }
    return c;
    }

    public void list() {
        // Read all customers from the file
        FileHandling fileH = new FileHandling("Meals_data.txt");
        String fileContent = fileH.ReadFile();
        Notification offer = new Notification();
        String[] lines = fileContent.split("\n");

        // Display each customer's information
        for (String line : lines) {
            if (!line.trim().isEmpty()) { // Check if the line is not empty or whitespace
                String[] mealData = line.split(",");
                if (mealData.length == 4) { // Check if the line has all expected data
                    System.out.println("ID: " + mealData[0] + ", Name: " + mealData[1] + ", price: " + (Integer.parseInt(mealData[2]) - (Integer.parseInt(mealData[2]) * (offer.makeOffer()) / 100)) );
                } else {
                    System.out.println("Invalid data: " + line);
                }
            }
        }
    }

}
