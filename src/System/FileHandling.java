package System;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandling {

    private File file;
    private String path;
    private FileWriter fw;//write in file
    private Scanner fs;//read from file ...

    public FileHandling(String path) {
        this.path = path;
    }

    public boolean createFile() {
        this.file = new File(path);

        try {
            if (file.createNewFile()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean WriteToFile(String s) {
        try {
            this.fw = new FileWriter(path, true);
            if (!ReadFile().isEmpty()) {
                fw.append("\n");
            }
            fw.append(s);
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updatesToFile(String s) {
        try {
            this.fw = new FileWriter(path, false);
            fw.write(s);
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public String ReadFile() {
        StringBuilder content = new StringBuilder();
        try {
            this.fs = new Scanner(new File(path));
            while (fs.hasNextLine()) {
                String line = fs.nextLine();
                if (!line.trim().isEmpty()) {
                    content.append(line).append("\n");
                }
            }
            fs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return content.toString();
    }

    public String ReadLine() {
        String line = "";
        try {
            this.fs = new Scanner(new File(path));

            if (fs.hasNextLine()) {
                line = fs.nextLine();
            }
            fs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return line;
    }

}
