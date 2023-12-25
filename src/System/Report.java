package System;

public class Report {
    private FileHandling fileHandler = new FileHandling("src\\Auth\\Users");


    public boolean list(int id) {
        // Read all Employees from the file
        String fileContent = fileHandler.ReadFile();
        String[] lines = fileContent.split("\n");

        // Display  Employee's information with given id
        for (String line : lines) {
            if (!line.trim().isEmpty()) { // Check if the line is not empty or whitespace
                String[] employeeData = line.split(",");
                if (employeeData.length == 7 && employeeData[0].equals(Integer.toString(id))&&employeeData[1].equals("2")) {
                    // Check if the line has all expected data
                    System.out.println("ID: " + employeeData[0] + ", Name: " + employeeData[4] + ", Salary: " + employeeData[6] + ",Email:" + employeeData[5]);
                    return true;
                }
            }
        }

   return false;
}

    public boolean listcus(int id) {
        // Read all customers from the file
        String fileContent = fileHandler.ReadFile();
        String[] lines = fileContent.split("\n");

        // Display  customer's information with given id
        for (String line : lines) {
            if (!line.trim().isEmpty()) { // Check if the line is not empty or whitespace
                String[] CustomerData = line.split(",");
                if (CustomerData.length == 7 && CustomerData[0].equals(Integer.toString(id)) && CustomerData[1].equals("3")) { // Check if the line has all expected data
                    System.out.println("ID: " + CustomerData[0] + ", Name: " + CustomerData[4] + ",Email:" + CustomerData[5]);
                    return true;
                }
            }
        }
    return false;
    }
}
