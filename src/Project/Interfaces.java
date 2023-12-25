package Project;
import Auth.auth;
import java.util.Scanner;
import static java.lang.System.exit;
import static java.lang.System.setOut;

import System.*;
import Users.*;

public class Interfaces {

    protected Scanner s;
    public String userName;
    public int userID;
    public int userType;

    public Interfaces() {
        try {
            this.s = new Scanner(System.in);
            System.out.println("---WELCOME IN Restaurant MANAGEMENT SYSTEM----");
            String choice;
            do {

                System.out.println(" 1.Login..");
                System.out.println(" 2.Exit.");
                System.out.println("Enter Your Choice...: ");
                choice = s.next();
                switch (choice) {
                    case "1":
                        login_menu();
                        break;
                    case "2":
                        exit(1);
                        break;
                    default:
                        System.out.println("Invalid Option...");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void login_menu() {
        int User_type;
        auth login = new auth();

        System.out.println("Enter UserName : ");
        String UserName = s.next();

        System.out.println("Enter Password : ");
        String Password = s.next();

        login.setUserName(UserName);
        login.setPassword(Password);
        login.check(login);

        User_type = login.getType();

        this.userName = login.getUserName();
        this.userType = login.getType();
        this.userID = login.getId();

        switch (User_type) {

            case 1:
                Admin_menu();
                break;
            case 2:
                Employee_menu();
                break;
            case 3:
                Customer_menu();
                break;

            default:
                System.out.println("UserName Or PassWord Invalid...");
                break;
        }

    }

    public void Admin_menu() {
        try {
            System.out.println("----Welcome Admin----");
            String choice;
            do {
                System.out.println("1)Manage Employee");
                System.out.println("2)Manage Meals");
                System.out.println("3)Make Reports");
                System.out.println("4)Make Offers");
                System.out.println("5)Edit Your Information");
                System.out.println("6)Exit Menu");
                System.out.println("----------------------");
                choice = s.next();
                if (choice.equals("6")) {
                    break;
                }
                switch (choice) {

                    case "1":
                        manage_Employee_menu();
                        break;
                    case "2":
                        manage_meal_menu();
                        break;
                    case "3":
                        Make_Reports_menu();
                        break;
                    case "4":
                        Admin make_offer = new Admin();
                        System.out.println("Enter the percentage of discount you want to apply: ");
                        int discount = s.nextInt();
                        make_offer.make_offer(discount);
                        break;
                    case "5":
                        Edit_info_menu();
                        break;
                    default:
                        System.out.println("Invalid option..");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void manage_Employee_menu() {
        try {
            String choice;
            do {
                System.out.println("1)Add Employee");
                System.out.println("2)Delete Employee");
                System.out.println("3)Update Employee");
                System.out.println("4)List Employee");
                System.out.println("5)search ");
                System.out.println("6)Exit Menu");
                choice = s.next();
                if (choice.equals("6")) {
                    break;
                }
                switch (choice) {

                    case "1":
                        add_emp_menu();
                        break;
                    case "2":
                        System.out.println("Enter ID to Delete :");
                        int id = s.nextInt();
                        Employee Delete_Employee = new Employee();
                        if (Delete_Employee.delete(id)) {
                            System.out.println("Deleted Successfully");
                        } else {
                            System.out.println("Delete Denied");
                        }

                        break;
                    case "3":
                        update_emp_menu();
                        break;
                    case "4":
                        Employee List_Employee = new Employee();
                        List_Employee.list();
                        //List Employee...
                        break;
                    case "5":
                        System.out.println("Enter Name To Search : ");
                        String Search_name = s.next();
                        Employee Search_Employee = new Employee();
                        String searched_data = Search_Employee.search(Search_name);
                        if (searched_data == "") {
                            System.out.println("Invalid Name");
                        } else {
                            System.out.println(searched_data);//Search employee...
                        }
                        break;
                    default:
                        System.out.println("Invalid option..");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void manage_meal_menu() {
        try {
            String choice;
            do {
                System.out.println("---------------");
                System.out.println("1)Add meal");
                System.out.println("2)Delete meal");
                System.out.println("3)Update meal");
                System.out.println("4)List meal");//
                System.out.println("5)search");
                System.out.println("6)Exit Menu");
                System.out.println("---------------");

                choice = s.next();
                if (choice.equals("6")) {
                    break;
                }
                switch (choice) {

                    case "1":

                        add_meal_menu();
                        // add meal
                        break;
                    case "2":
                        System.out.println("Enter ID to Delete :");
                        int id = s.nextInt();
                        Meals deleted_meal = new Meals();

                        if (deleted_meal.delete(id)) {
                            System.out.println("Deleted Successfully");
                        } else {
                            System.out.println("Delete Denied");
                        }
                        //Delete meal
                        break;
                    case "3":
                        update_meal_menu();
                        //Update meal..
                        break;
                    case "4":
                        Meals List_meal = new Meals();
                        List_meal.list();
                        //List meal...
                        break;
                    case "5":
                        System.out.println("Enter Name To Search : ");
                        String Search_name = s.next();
                        Meals Search_meal = new Meals();
                        String searched_data = Search_meal.search(Search_name);
                        if (searched_data == "") {
                            System.out.println("Invalid Name");
                        } else {
                            System.out.println(searched_data);//Search employee...
                        }

                        //Search meal...
                        break;
                    default:
                        System.out.println("Invalid option..");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void Make_Reports_menu() {
        try {
            String choice;
            do {
                System.out.println("--------------------------");
                System.out.println("1)make report for Employee");
                System.out.println("2)make report for customer");
                System.out.println("3)List Employee");
                System.out.println("4)List customer");
                System.out.println("5)Exit Menu");
                System.out.println("--------------------------");
                choice = s.next();
                if (choice.equals("5"))
                {
                    break;
                }
                switch (choice) {

                    case "1":
                        // make report Employee
                        System.out.println("Enter id for employee to make report: ");
                        int id_Emp = s.nextInt();
                        Report Emp_report = new Report();
                          if(!Emp_report.list(id_Emp))
                           System.out.println("Not found..");
                        break;
                    case "2":
                        System.out.println("Enter id for customer to make report: ");
                        int id_Cus = s.nextInt();
                        Report Cus_report = new Report();
                       if(!Cus_report.listcus(id_Cus))
                           System.out.println("Not Found..");
                        //make report customer
                        break;
                    case "3":
                        Employee List_Emp = new Employee();
                        List_Emp.list();
                        //list Employee..
                        break;
                    case "4":
                        Customer List_Cus = new Customer();
                        List_Cus.list();
                        //List Customer...
                        break;

                    default:
                        System.out.println("Invalid option..");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void Edit_info_menu() {
        try {
            auth Edit_info = new auth();
            System.out.println("Enter Your ID to Edit Your information (But You cannot edit id..) : ");
            int id = s.nextInt();
            if(userID==id){

            System.out.println("Enter New UserName : ");
            String New_Username = s.next();
            Edit_info.setUserName(New_Username);

            System.out.println("Enter New Password : ");
            String New_Password = s.next();
            Edit_info.setPassword(New_Password);

            Edit_info.setType(userType);
            if (Edit_info.updated_Profile_info(id, Edit_info))
            {
                System.out.println(" Edit Successfully");
            }

            else
            {
                System.out.println("Id or Type False");
            }
            }
            else{
                System.out.println("invalid id");}
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void add_emp_menu() {
        try {
            Employee New_Employee = new Employee();
            New_Employee.setId();
            System.out.println("Enter Name : ");
            String name = s.next();
            New_Employee.setName(name);
            System.out.println("Enter Salary : ");
            double salary = s.nextDouble();
            New_Employee.setSalary(salary);
            System.out.println("Enter Email : ");
            String email = s.next();
            New_Employee.setEmail(email);
            if (New_Employee.add(New_Employee)) {
                System.out.println("Added Successfully..");
            } else {
                System.out.println("Added Denied");
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public void update_emp_menu() {
        try {
            String update_case;
            String name, email,user_name,pass;
            double salary;
            do {

                Employee Update_Employee = new Employee();

                System.out.println("Edit Employee: \n1. Edit all data\n2. Edit Name only\n3. Edit Salary only\n4. Edit Email only\n5. Exit this menu\n ");
                update_case = s.next();

                if (update_case.equals("5")) {
                    break;
                }

                if (!update_case.matches("[1-4]")) {
                    System.out.println("Invalid option. Please choose a valid option.");
                    continue;
                }

                System.out.println("Enter ID to Edit :");
                int id = s.nextInt();
                if (!Update_Employee.Check_ID(id)) {
                    System.out.println("invalid ID ");
                    continue;
                }

                switch (update_case) {
                    case "1":
                        System.out.println("Enter New Name :");
                        name = s.next();
                        Update_Employee.setName(name);

                        System.out.println("Enter New Salary :");
                        salary = s.nextDouble();
                        Update_Employee.setSalary(salary);

                        System.out.println("Enter New Email :");
                        email = s.next();
                        Update_Employee.setEmail(email);
                        break;
                    case "2":
                        System.out.println("Enter New Name :");
                        name = s.next();
                        Update_Employee.setName(name);
                        break;
                    case "3":
                        System.out.println("Enter New Salary :");
                        salary = s.nextDouble();
                        Update_Employee.setSalary(salary);
                        break;
                    case "4":
                        System.out.println("Enter New Email :");
                        email = s.next();
                        Update_Employee.setEmail(email);
                        break;
                    default:
                        System.out.println("Wrong Choice");
                        break;
                }
                if (Update_Employee.updated_Profile_info(id, Update_Employee)) {
                    System.out.println("Updated Successfully");
                } else {
                    System.out.println("Updated Denied");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void add_meal_menu() {
        try {
            Meals New_meal = new Meals();
            New_meal.setId();
            System.out.println("Enter Name : ");
            String name = s.next();
            New_meal.setName(name);
            System.out.println("Enter price : ");
            int price = s.nextInt();
            New_meal.setPrice(price);
            System.out.println("Enter Quantity : ");
            int quantity = s.nextInt();
            New_meal.setQuantity(quantity);
            if (New_meal.add(New_meal)) {
                System.out.println("Added Successfully..");
            } else {
                System.out.println("Added Denied");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update_meal_menu() {
        try {
            Meals update_meal = new Meals();
            String choice, name;
            int price, quantity;
            do {
                System.out.println("Edit Meal: \n1. Edit all data\n2. Edit Name only\n3. Edit price only\n4. Edit quantity only\n5. Exit this menu ");
                choice = s.next();
                if (choice.equals("5")) {
                    break;
                }
                System.out.println("Enter ID to Edit :");
                int id = s.nextInt();
                if (!update_meal.Check_ID(id)) {
                    System.out.println("invalid ID");
                    continue;
                }

                switch (choice) {
                    case "1":
                        System.out.println("Enter New Name :");
                        name = s.next();
                        update_meal.setName(name);
                        System.out.println("Enter New  Price :");
                        price = s.nextInt();
                        update_meal.setPrice(price);
                        System.out.println("Enter New Quantity :");
                        quantity = s.nextInt();
                        update_meal.setQuantity(quantity);
                        break;
                    case "2":
                        System.out.println("Enter New Name :");
                        name = s.next();
                        update_meal.setName(name);
                        break;
                    case "3":
                        System.out.println("Enter New  Price :");
                        price = s.nextInt();
                        update_meal.setPrice(price);
                        break;
                    case "4":
                        System.out.println("Enter New Quantity :");
                        quantity = s.nextInt();
                        update_meal.setQuantity(quantity);
                        break;

                }
                if (update_meal.update(id, update_meal)) {
                    System.out.println("Updated Successfully");
                } else {
                    System.out.println("Updated Denied");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Employee_menu() {
        try {
            System.out.println("----Welcome Employee----");
            String choice;

            do {
                System.out.println("1)Manage Customers");//
                System.out.println("2)Manage Orders");
                System.out.println("3)Manage Billing");
                System.out.println("4)Edit Your Information");
                System.out.println("5)Exit Menu");
                System.out.println("----------------------");
                choice = s.next();
                if (choice.equals("5")) {
                    break;
                }
                switch (choice) {

                    case "1":
                        manage_Customer_menu();
                        break;
                    case "2":
                        manage_order_menu();
                        break;
                    case "3":
                        Billing view_billing = new Billing();
                        view_billing.list();
                        //Billing
                        break;
                    case "4":
                        Edit_info_menu();
                        break;
                    default:
                        System.out.println("Invalid option..");
                }
            } while (true);
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public void manage_Customer_menu() {
        try {
            String choice;
            do {
                System.out.println("1)Add Customer");
                System.out.println("2)Delete Customer");
                System.out.println("3)Update Customer");
                System.out.println("4)List Customer");
                System.out.println("5)search ");
                System.out.println("6)Exit Menu");
                choice = s.next();
                if (choice.equals("6")) {
                    break;
                }
                switch (choice) {

                    case "1":
                        add_Cus_menu();
                        break;
                    case "2":
                        System.out.println("Enter ID to Delete :");
                        int id = s.nextInt();
                        Customer Delete_Customer = new Customer();
                        if (Delete_Customer.delete(id)) {
                            System.out.println("Deleted Successfully");
                        } else {
                            System.out.println("Delete Denied");
                        }

                        break;
                    case "3":
                        update_Cus_menu();
                        break;
                    case "4":
                        Customer List_Customer = new Customer();
                        List_Customer.list();
                        break;
                    case "5":
                        System.out.println("Enter Name To Search : ");
                        String Search_name = s.next();
                        Customer Search_Customer = new Customer();
                        String searched_data = Search_Customer.search(Search_name);
                        if (searched_data == "") {
                            System.out.println("Name not Found");
                        } else {
                            System.out.println(searched_data);//Search employee...
                        }

                        break;
                    default:
                        System.out.println("Invalid option..");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void manage_order_menu() {
        try {
            System.out.println("---------------");
            System.out.println("1)Make Order ");
            System.out.println("2)Cancel Order : ");
            System.out.println("---------------");

            int c = s.nextInt();

            switch (c) {

                case 1:
                    make_order_menu();
                    // Make Order..
                    break;
                case 2:
                    Cancel_order_menu_emp();
                    //Cancel Order...
                    break;

                default:
                    System.out.println("Invalid option..");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void add_Cus_menu() {
        try {
            Customer New_Customer = new Customer();
            New_Customer.setId();
            System.out.println("Enter Name : ");
            String name = s.next();
            New_Customer.setName(name);
            System.out.println("Enter Email : ");
            String email = s.next();
            New_Customer.setEmail(email);
            if (New_Customer.add(New_Customer)) {
                System.out.println("Added Successfully..");
            } else {
                System.out.println("Added Denied");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update_Cus_menu() {
        try {
            Customer Update_Customer = new Customer();

             String update_case,name,email;
           do{

               System.out.println("Edit Customer: \n1. Edit all data\n2. Edit Name only\n3. Edit Email only\n4. Exit this menu ");
               update_case = s.next();
               if (update_case.equals("4"))
               {
                   break;
               }
            System.out.println("Enter ID to Edit :");
            int id = s.nextInt();
               if (!Update_Customer.Check_ID(id)) {
                   System.out.println("invalid ID");
                   continue;
               }
            switch (update_case) {
                case "1":
                    System.out.println("Enter New Name :");
                    name = s.next();
                    Update_Customer.setName(name);

                    System.out.println("Enter New Email :");
                    email = s.next();
                    Update_Customer.setEmail(email);
                    break;
                case "2":
                    System.out.println("Enter New Name :");
                    name = s.next();
                    Update_Customer.setName(name);
                    break;
                case "3":
                    System.out.println("Enter New Email :");
                    email = s.next();
                    Update_Customer.setEmail(email);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            if (Update_Customer.update(id, Update_Customer)) {
                System.out.println("Updated Successfully");
            } else {
                System.out.println("Updated Denied");
            }}while (true);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void Customer_menu() {
        try {
            System.out.println("Welcome Customer....");
            String choice;
            do {
                System.out.println("1)Make Order");//
                System.out.println("2)Cancel Order");
                System.out.println("3)Show Notification");
                System.out.println("4)Edit Your Information");
                System.out.println("5)Exit Menu");

                System.out.println("----------------------");
                choice = s.next();
                if (choice.equals("5")) {
                    break;
                }
                switch (choice) {

                    case "1":
                        make_order_menu();
                        break;
                    case "2":
                        Cancel_order_menu_cus();
                        break;
                    case "3":
                        Notification show_not = new Notification();
                        show_not.displayNotification();
                        break;
                    case "4":
                        Edit_info_menu();
                        break;
                    default:
                        System.out.println("Invalid option..");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void make_order_menu() {
        try {
            Orders Make_order = new Orders();
            Notification offers = new Notification();
            Meals meal = new Meals();
            Make_order.list();//list menu..

            System.out.println("Enter ID of The Meal To Make Order : ");
            int id_make = s.nextInt();
            String Meal_data = meal.getName_Price(id_make);

            String[] meal_data = Meal_data.split(",");/// price ,name
            if (id_make == Integer.parseInt(meal_data[0])) {
                System.out.println("Enter Quantity: ");
                int quantity = s.nextInt();
                if (quantity <= Integer.parseInt(meal_data[3])) {
                    Make_order.setId();
                    Make_order.setCustomerId(userID);
                    Make_order.setMealName(meal_data[1]);
                    Make_order.setQuantitiy(quantity);
                    int price = Integer.parseInt(meal_data[2]);
                    Make_order.setTotalAmount(price - price * (offers.makeOffer()) / 100);
                    Make_order.makeOrder(Make_order);
                    meal.setQuantity(Integer.parseInt(meal_data[3]) - quantity);
                    meal.update(id_make, meal);
                } else {
                    System.out.println("Sold out..");
                }
            } else {
                System.out.println("ID invalid ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void Cancel_order_menu_cus() {
        try {
            Orders Cancel_order = new Orders();
            boolean check=Cancel_order.list(userID);
            if(!check) {
                System.out.println("There is no customer whis this ID");}


           else{
            System.out.println("Enter Id Of Order You went delete : ");
            int id_Cancel = s.nextInt();
            if(!Cancel_order.CanelOrder(id_Cancel,userID))
                System.out.println("Invalid id..");
            else
                System.out.println("Deleted successfully");
           }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    void Cancel_order_menu_emp() {
        try
        {
            Orders Cancel_order = new Orders();
            System.out.println("Enter Persons ID: ");
            int id_cus = s.nextInt();
            boolean check=Cancel_order.list(id_cus);
            if(!check) {
                System.out.println("There is no customer whis this ID");
            }


            else{
                System.out.println("Enter Id Of Order You went delete : ");
                int id_Cancel = s.nextInt();
                if(!Cancel_order.CanelOrder(id_Cancel,id_cus))
                    System.out.println("Invalid id..");
                else
                    System.out.println("Deleted successfully");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
