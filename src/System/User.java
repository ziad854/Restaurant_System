package System;

public class User {

    private static FileHandling fileHandler_data;
    protected int id;
    protected String UserName;
    protected String Password;

    protected String name;
    protected double salary;
    protected String email;
    protected int type;  //1->Admin 2->Employee 3->Customer..

    public User() {
        fileHandler_data = new FileHandling("src\\Auth\\Users");
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setId(int id) {
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean updated_Profile_info(int id, User user) {
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");
        String updatedContent = "";
        // Find the User with the same ID as the updated User
        for (String line : lines) {
            String[] UserData = line.split(",");
            if (UserData[0].equals(Integer.toString(id))) {
                updatedContent += id + ","
                        + ((user.getType() == 0) ? UserData[1] : user.getType()) + ","
                        + ((user.getUserName() == null) ? UserData[2] : user.getUserName()) + ","
                        + ((user.getPassword() == null) ? UserData[3] : user.getPassword()) + ","
                        + ((user.getName() == null) ? UserData[4] : user.getName()) + ","
                        + ((user.getEmail() == null) ? UserData[5] : user.getEmail()) + ","
                        + ((user.getSalary() == 0) ? UserData[6] : user.getSalary()) + "\n";
            } else {
                updatedContent += line + "\n";
            }
        }

        // Write the updated content back to the file
        return fileHandler_data.updatesToFile(updatedContent);
    }
}
