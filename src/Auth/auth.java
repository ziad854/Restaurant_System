package Auth;

import System.*;

public class auth extends User {

    private static FileHandling fileHandler_data;

    public auth() {
        this.fileHandler_data = new FileHandling("src\\Auth\\Users");
    }

    public auth(String new_username, String new_password) {
    }

    public boolean login() {

        String userName = getUserName();
        int type = getType();
        if (userName != null && !userName.isEmpty()) {
            if (type == 1) {
                setId(1);
            } else if (type == 2) {
                setId(2);
            } else if (type == 3) {
                setId(3);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean check(auth u) {
        String fileContent = fileHandler_data.ReadFile();
        String[] data = fileContent.split("\n");
        boolean c = false;
        for (String line : data) {
            String[] UserData = line.split(",");
            if (UserData[2].equals(u.getUserName()) && UserData[3].equals(u.getPassword())) {
                c = true;
                int usertype = Integer.parseInt(UserData[1]);
                u.setType(usertype);
                u.setId(Integer.parseInt(UserData[0]));
            }
        }

        return c;
    }

}
