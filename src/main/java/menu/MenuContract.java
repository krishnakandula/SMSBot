package menu;

import data.models.Contact;

import java.util.List;

/**
 * Created by krishnakandula on 1/21/17.
 */
public interface MenuContract {
    interface View {
        void onCreate();
        void showMainMenu();
        void showContactList();
        void showContactListOptions();
        void addContact();
        void selectContact();
        void showContactOptions();
        void showMessageTextView();
        void displayToast(String toastMessage);
    }

    interface Presenter {
        List<Contact> getContactList();
        void onMainMenuOptionSelected(int option);
        void onContactListOptionSelected(int option);
        void onContactOptionsSelected(int option);
        void addContact(String name, String phoneNumber);
        void sendMessage(String message);
        void setSelectedContact(int selectedContactIndex);
        void deleteContact();
    }
}
