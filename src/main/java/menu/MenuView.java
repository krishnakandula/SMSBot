package menu;

import com.sun.istack.internal.NotNull;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import config.Config;
import data.BaseRepository;
import data.ContactRepository;
import data.models.Contact;

import java.util.List;
import java.util.Scanner;

/**
 * Created by krishnakandula on 1/20/17.
 */
public class MenuView implements MenuContract.View{
    public static Scanner inputScanner;
    private MenuContract.Presenter presenter;

    public MenuView(MenuContract.Presenter presenter){
        this.presenter = presenter;
    }

    public void onCreate(){
        inputScanner = new Scanner(System.in);
    }

    private static void initializeTwilio(){
        Twilio.init(Config.TWILIO_ACCOUNT_SID, Config.TWILIO_AUTH_TOKEN);

        PhoneNumber fromPhoneNumber = new PhoneNumber(Config.TWILIO_FROM_PHONE_NUMBER);
        PhoneNumber toPhoneNumber = new PhoneNumber(Config.MY_PHONE_NUMBER);
        Message message = Message.creator(toPhoneNumber, fromPhoneNumber, "Hi there")
                .create();
        System.out.println(message.getSid());
    }

    public void showMainMenu(){
        System.out.println("WELCOME!");
        System.out.println("1. -----VIEW CONTACTS-----");
        System.out.println("2. ------ADD CONTACT------");
        System.out.println("3. ---------EXIT----------");

        //Get user input
        int userInput = inputScanner.nextInt();

        switch (userInput){
            case 1: showContactList();
                break;
            case 2: addContact();
                break;
            default: return;
        }
    }

    public void showContactList(){
        ContactRepository.getContactRepository().getContactList(new BaseRepository.ContactListLoadedCallback() {
            public void onContactListLoaded(@NotNull List<Contact> contactList) {
                for(int index = 0; index < contactList.size(); index++){
                    StringBuilder builder = new StringBuilder();
                    builder.append(index + ": ").append(contactList.get(index));
                    System.out.println(builder.toString());
                }
            }
        });
        showViewContactListOptions();
    }

    //TODO: Move to presenter
    private static void addContact(){
        System.out.println("Enter the Contacts name: ");
        String contactName = inputScanner.nextLine();
        System.out.println("Enter the contacts phone number: ");
        String phoneNumber = inputScanner.nextLine();

        Contact contact = new Contact();
        contact.setName(contactName);
        contact.setPhoneNumber(phoneNumber);

        ContactRepository.getContactRepository().addContact(contact);
    }

    private static void showViewContactListOptions(){
        System.out.println("OPTIONS");
        System.out.println("1. -------SEND MESSAGE-------");
        System.out.println("2. ------DELETE CONTACT------");
        System.out.println("3. --------MAIN MENU---------");

        int option = inputScanner.nextInt();

        switch (option){
            case 1:

        }
    }

    public void showContactListOptions() {

    }
}
