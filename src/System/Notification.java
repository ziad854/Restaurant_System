package System;


public class Notification {

    private static FileHandling fileHandler_data;

    public Notification (){
        this.fileHandler_data  = new FileHandling("offers");
    }
    public void displayNotification(){
        String filecontent = fileHandler_data.ReadFile();
        String[] lines = filecontent.split("\n");
        for (String line : lines){
            System.out.println(line);
        }
    }
    public int makeOffer(){
        String fileContent = fileHandler_data.ReadFile();
        String offer;
        if (!fileContent.trim().isEmpty()){
            String[] lines = fileContent.split("\n");
            for (String line : lines){
                offer = (line.split(" "))[3].replace("%", "").trim();
                return Integer.parseInt(offer);
            }
        }
        return 0;
    }
}
