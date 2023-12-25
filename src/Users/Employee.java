package Users;

import System.User;
import System.CrudEmp;
import System.FileHandling;

public class Employee extends User implements CrudEmp {

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


    public Employee() {
        fileHandler_data = new FileHandling("src\\Auth\\Users");
    }


    @Override
    public boolean add(Employee emp) {
        String Default_user =(emp.getName()+ emp.getId());
        String Default_pass = "123";
        String EmployeeData = emp.getId()+"," + "2"+ "," + Default_user + "," + Default_pass + "," + emp.getName() + "," + emp.getEmail() + "," + emp.getSalary() ;
        return fileHandler_data.WriteToFile(EmployeeData);
    }

    @Override
    public boolean delete(int id) {
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");
        String updatedContent = "";
        boolean cheak = false;
        // Find and remove the Employee with the given ID
        for (String line : lines) {
            String[] employeeData = line.split(",");
            if (employeeData[0].equals(Integer.toString(id))&&employeeData[1].equals("2")) {
                    cheak = true;
            } else {
                updatedContent += line + "\n";
            }
        }
        fileHandler_data.updatesToFile(updatedContent);

        return cheak;
    }

    @Override
    public boolean update(int id, Employee updatedemployee) {
        // Read all Employees from the file
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");

        String updatedContent = "";

        boolean cheak = false;
        // Find the Employee with the same ID as the updated Employee
        for (String line : lines) {
            String[] employeeData = line.split(",");

            if (employeeData[0].equals(Integer.toString(id))) {
                if(employeeData[1].equals("2"))
                updatedContent += id + ","
                        + ((updatedemployee.getName() == null) ? employeeData[4] : updatedemployee.getName()) + ","
                        + ((updatedemployee.getSalary() == 0) ? employeeData[6] : updatedemployee.getSalary()) + ","
                        + ((updatedemployee.getEmail() == null) ? employeeData[5] : updatedemployee.getEmail()) + "\n";
                cheak = true;
            } else {
                updatedContent += line + "\n";
            }
        }
        fileHandler_data.updatesToFile(updatedContent);
        // Write the updated content back to the file
        return cheak;
    }

    @Override
    public void list() {
        // Read all Employees from the file
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");

        // Display each Employee's information
        for (String line : lines) {
            if (!line.trim().isEmpty()) { // Check if the line is not empty or whitespace
                String[] employeeData = line.split(",");
                if (employeeData.length == 7 ) {
                    // Check if the line has all expected data
                    if(employeeData[1].equals("2"))
                        System.out.println("ID: " + employeeData[0] + ", Name: " + employeeData[4] + ", Salary: " + employeeData[6] + ",Email:" + employeeData[5]);
                }
                else
                {
                    System.out.println("Invalid data: " + line);
                }
            }
        }

    }

    public boolean Check_ID(int id) {
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");
        // check id,type...
        for (String line : lines) {
            String[] UserData = line.split(",");
            if (UserData[0].equals(Integer.toString(id)) && UserData[1].equals("2")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String search(String Name) {
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");
        String Employee_searched = "";
        // Find and Get the Employee with the given Name
        for (String line : lines) {
            String[] employeeData = line.split(",");
            if (employeeData[4].equals(Name) && employeeData.length == 7) {
                if(employeeData[1].equals("2"))
                Employee_searched += "ID: " + employeeData[0] + ", Name: " + employeeData[4] + ", Salary: " + employeeData[6] + ",Email:" + employeeData[5];
            }
        }
        return Employee_searched;
    }

}
