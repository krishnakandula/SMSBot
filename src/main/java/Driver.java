import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 * Created by krishnakandula on 1/20/17.
 */
public class Driver {
    private static final String TO_PHONE_NUMBER = "2146979165";

    public static void main(String... args){
        Twilio.init(Config.TWILIO_ACCOUNT_SID, Config.TWILIO_AUTH_TOKEN);

        PhoneNumber fromPhoneNumber = new PhoneNumber(Config.TWILIO_FROM_PHONE_NUMBER);
        PhoneNumber toPhoneNumber = new PhoneNumber(TO_PHONE_NUMBER);
        Message message = Message.creator(toPhoneNumber, fromPhoneNumber, "Hi Sexy")
                .create();
        System.out.println(message.getSid());
    }
}
