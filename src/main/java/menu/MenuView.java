package menu;

import data.models.Contact;
import service.ServiceContract;

import java.util.List;
import java.util.Scanner;

/**
 * Created by krishnakandula on 1/20/17.
 */
public class MenuView implements MenuContract.View{
    public static Scanner inputScanner;
    private MenuContract.Presenter presenter;

    public MenuView(ServiceContract smsService){
        presenter = new MenuPresenter(this, smsService);
    }

    //Start method
    public void onCreate(){
        inputScanner = new Scanner(System.in);
        showMainMenu();
    }

    public void showMainMenu(){
        System.out.println("MAIN MENU");
        System.out.println("1. -----VIEW CONTACTS-----");
        System.out.println("2. ------ADD CONTACT------");
        System.out.println("3. ---------EXIT----------");

        int userInput = inputScanner.nextInt();
        inputScanner.nextLine();
        presenter.onMainMenuOptionSelected(userInput);
    }

    public void showContactList(){
        List<Contact> contactList = presenter.getContactList();
        for(int index = 0; index < contactList.size(); index++){
            StringBuilder builder = new StringBuilder();
            builder.append(index + ": ").append(contactList.get(index));
            System.out.println(builder.toString());
        }
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
        System.out.println("1. ------SELECT CONTACT------");
        System.out.println("2. --------MAIN MENU---------");
        System.out.println("Select an option: ");

        int userInput = inputScanner.nextInt();
        inputScanner.nextLine();
        presenter.onContactListOptionSelected(userInput);
    }

    public void selectContact(){
        System.out.println("Enter the index for the contact you want to select: ");
        int userInput = inputScanner.nextInt();
        inputScanner.nextLine();
        presenter.setSelectedContact(userInput);
    }

    public void showContactOptions() {
        System.out.println("CONTACT OPTIONS");
        System.out.println("1. -------SEND MESSAGE-------");
        System.out.println("2. ------DELETE CONTACT------");
        System.out.println("3. --------MAIN MENU---------");
        System.out.println("Select an option: ");

        int userInput = inputScanner.nextInt();
        inputScanner.nextLine();
        presenter.onContactOptionsSelected(userInput);
    }

    public void showMessageTextView() {
        System.out.println("ENTER MESSAGE: ");
        String userInput = inputScanner.nextLine();

        presenter.sendMessage(userInput);
    }

    public void displayToast(String toastMessage) {
        System.out.println(toastMessage);
    }
}
