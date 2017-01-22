import data.db.DBOpenHelper;
import menu.MenuContract;
import menu.MenuView;
import service.TwilioService;

/**
 * Created by krishnakandula on 1/21/17.
 */
public class Driver {
    public static void main(String... args){
        DBOpenHelper.getDbOpenHelper().initializeDb();

        MenuContract.View mainMenuView = new MenuView(TwilioService.getTwilioService());
        mainMenuView.onCreate();
    }
}
