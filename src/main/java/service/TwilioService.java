package service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import config.Config;

/**
 * Created by krishnakandula on 1/21/17.
 */
public class TwilioService implements ServiceContract{
    private static TwilioService service;

    private TwilioService(){
        initializeTwilio();
    }

    private static void initializeTwilio(){
        Twilio.init(Config.TWILIO_ACCOUNT_SID, Config.TWILIO_AUTH_TOKEN);
    }

    public static TwilioService getTwilioService(){
        if(service == null)
            service = new TwilioService();
        return service;
    }

    public void sendMessage(String from, String to, String message) {
        PhoneNumber toNumber = new PhoneNumber(to);
        PhoneNumber fromNumber = new PhoneNumber(from);
        Message twilioMessage = Message.creator(toNumber, fromNumber, message).create();
        twilioMessage.getSid();
    }
}
