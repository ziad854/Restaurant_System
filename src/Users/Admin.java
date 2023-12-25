package Users;
import System.*;

public class Admin extends User
{
    private static FileHandling fileHandler_data;

     public Admin()
     {
         this.fileHandler_data=new FileHandling("offers");
     }
    public void make_offer(int discount)
    {
        //There is a discount% discount on all meals
        fileHandler_data.updatesToFile("there is a "+Integer.toString(discount)+"% "+"discount on all meals");
    }
}
