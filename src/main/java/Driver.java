import com.twilio.Twilio;
import config.Config;
import menu.MenuContract;
import menu.MenuView;

/**
 * Created by krishnakandula on 1/21/17.
 */
public class Driver {
    public static void main(String... args){
        initializeTwilio();
        MenuContract.View mainMenuView = new MenuView();
        mainMenuView.onCreate();
    }

    private static void initializeTwilio(){
        Twilio.init(Config.TWILIO_ACCOUNT_SID, Config.TWILIO_AUTH_TOKEN);
    }
}
