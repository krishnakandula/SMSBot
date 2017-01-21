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
    }

    interface Presenter {
        void onMainMenuOptionSelected(int option);
        void getContactList(OnContactListLoadedListener listener);
        void onContactListOptionSelected(int option);
        void addContact(String name, String phoneNumber);

        interface OnContactListLoadedListener {
            void onListLoaded(List<Contact> contactList);
        }
    }
}
