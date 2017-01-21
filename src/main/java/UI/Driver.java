package ui;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import config.Config;

/**
 * Created by krishnakandula on 1/20/17.
 */
public class Driver {
    public static void main(String... args){
        Twilio.init(Config.TWILIO_ACCOUNT_SID, Config.TWILIO_AUTH_TOKEN);

        PhoneNumber fromPhoneNumber = new PhoneNumber(Config.TWILIO_FROM_PHONE_NUMBER);
        PhoneNumber toPhoneNumber = new PhoneNumber(Config.MY_PHONE_NUMBER);
        Message message = Message.creator(toPhoneNumber, fromPhoneNumber, "Hi there")
                .create();
        System.out.println(message.getSid());
    }
}
