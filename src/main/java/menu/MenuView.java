package menu;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import config.Config;
import data.models.Contact;

import java.util.List;
import java.util.Scanner;

/**
 * Created by krishnakandula on 1/20/17.
 */
public class MenuView implements MenuContract.View{
    public static Scanner inputScanner;
    private MenuContract.Presenter presenter;

    public void onCreate(){
        presenter = new MenuPresenter(this);
        inputScanner = new Scanner(System.in);
        showMainMenu();
    }

    public void showMainMenu(){
        System.out.println("WELCOME!");
        System.out.println("1. -----VIEW CONTACTS-----");
        System.out.println("2. ------ADD CONTACT------");
        System.out.println("3. ---------EXIT----------");

        int userInput = inputScanner.nextInt();
        presenter.onMainMenuOptionSelected(userInput);
    }

    public void showContactList(){
        presenter.getContactList(new MenuContract.Presenter.OnContactListLoadedListener() {
            public void onListLoaded(List<Contact> contactList) {
                for(int index = 0; index < contactList.size(); index++){
                    StringBuilder builder = new StringBuilder();
                    builder.append(index + ": ").append(contactList.get(index));
                    System.out.println(builder.toString());
                }
                showContactListOptions();
            }
        });
    }

    public void addContact(){
        System.out.println("Enter the Contacts name: ");
        String contactName = inputScanner.next();
        System.out.println("Enter the contacts phone number: ");
        String phoneNumber = inputScanner.next();

        presenter.addContact(contactName, phoneNumber);
    }

    public void showContactListOptions() {
        System.out.println("OPTIONS");
        System.out.println("1. -------SEND MESSAGE-------");
        System.out.println("2. ------DELETE CONTACT------");
        System.out.println("3. --------MAIN MENU---------");
        System.out.println("Select an option: ");

        int userInput = inputScanner.nextInt();
        presenter.onContactListOptionSelected(userInput);
    }
}
