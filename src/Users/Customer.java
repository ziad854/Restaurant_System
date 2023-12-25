package Users;
import System.*;
public class Customer extends User implements CrudCus {

    private static FileHandling fileHandler_data;
    private static int nextId = 1;

    public void setId() {
        String filecontent = fileHandler_data.ReadFile();
        String[] lines = filecontent.split("\n");
        if (filecontent.isEmpty()) {
            this.id = nextId;
        } else {

            String[] mealData = lines[lines.length - 1].split(",");
            this.id = (Integer.parseInt(mealData[0])) + 1;
        }
    }

    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private String Email;

    public Customer() {
        this.fileHandler_data = new FileHandling("src\\Auth\\Users");
    }

    @Override
    public boolean add(Customer Cus) {
        String Default_user =(Cus.getName()+ Cus.getId());
        String Default_pass = "123";
        String CustomerData = Cus.getId() + "," +"3" + "," + Default_user+ "," + Default_pass + Cus.getName() + "," + Cus.getEmail() +","+ "0";
        return fileHandler_data.WriteToFile(CustomerData);
    }

    @Override
    public boolean delete(int id) {
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");
        boolean check=false;
        String updatedContent = "";
        // Find and remove the Customer with the given ID
        for (String line : lines) {
            String[] CustomerData = line.split(",");
            if (CustomerData[0].equals(Integer.toString(id)) && CustomerData[1].equals("3")) {
                check=true;//
            }
            else
            {
                updatedContent += line + "\n";
            }
        }
       fileHandler_data.updatesToFile(updatedContent);

        return check;
    }

    @Override
    public boolean update(int id, Customer updatedCustomer) {
        // Read all Customers from the file
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");
        String updatedContent = "";
        // Find the Customer with the same ID as the updated Customer
        for (String line : lines) {
            String[] customerData = line.split(",");

            if (customerData[0].equals(Integer.toString(id))) {
                updatedContent += id + ","
                        + customerData[1] + "," + customerData[2] + "," + customerData[3] + ","
                        + ((updatedCustomer.getName() == null) ? customerData[4] : updatedCustomer.getName()) + ","
                        + ((updatedCustomer.getEmail() == null) ? customerData[5] : updatedCustomer.getEmail())+ "," + "0" + "\n";
            } else {
                updatedContent += line + "\n";
            }
        }

        // Write the updated content back to the file
        return fileHandler_data.updatesToFile(updatedContent);

    }

    @Override
    public void list() {
        // Read all Customers from the file
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");
        // Display each Customer's information
        for (String line : lines) {
            if (!line.trim().isEmpty()) { // Check if the line is not empty or whitespace
                String[] CustomerData = line.split(",");
                if (CustomerData.length ==7) { // Check if the line has all expected data
                    if(CustomerData[1].equals("3"))
                        System.out.println("ID: " + CustomerData[0] + ", Name: " + CustomerData[4] + ",Email:" + CustomerData[5]);
                } else {
                    System.out.println("Invalid data: " + line);
                }
            }
        }

    }

    @Override
    public String search(String Name) {
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");
        String meal_searched = "";

        // Find and Get the Customer with the given Name
        for (String line : lines) {
            String[] CustomerData = line.split(",");
            if (CustomerData[4].equals(Name) && CustomerData.length == 7 && CustomerData[1].equals("3")) {
                meal_searched += "ID: " + CustomerData[0] + ", Name: " + CustomerData[4] + ",Email:" + CustomerData[5];
            }
        }
        return meal_searched;
    }

    @Override
    public boolean Check_ID(int id) {
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");
        // check id,type...
        for (String line : lines) {
            String[] UserData = line.split(",");
            if (UserData[0].equals(Integer.toString(id)) && UserData[1].equals("3")) {
                return true;
            }
        }
        return false;
    }

    public String search(int id) {
//        FileHandling file_hand=new FileHandling("C:\\Users\\ziad8\\Downloads\\Compressed\\FInal\\src\\Auth\\Users");
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");
        // Find and remove the customer with the given ID
        for (String line : lines) {
            String[] customerData = line.split(",");
            if (customerData.length == 7) {
                int customerId = Integer.parseInt(customerData[0]);
                if (customerId == id) {
                    return line; // Return the name of the customer
                }
            }
        }
        return null;
    }

    @Override
    public void list_orders() {
        // Read all orders from the file
        Customer customer = new Customer();

        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");

        // Display each order's information
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                String[] orderData = line.split(",");
                int customerId = Integer.parseInt(orderData[1]);

                String customerInfo = customer.search(customerId);
                if (customerInfo != null) {
                    String[] customerData = customerInfo.split(",");

                    if (orderData.length == 4) { // Check if the line has all expected data
                        System.out.println("Order ID: " + orderData[0] +
                                ", Customer ID: " + customerId +
                                ", Customer Name: " + customerData[1] +
                                ", Meal Name: " + orderData[2] +
                                ", Total Amount: " + orderData[3] +
                                ", Quantity: "  +  orderData[4]);
                    } else {
                        System.out.println("Invalid data: " + line);
                    }
                }
            }
        }
    }
}
