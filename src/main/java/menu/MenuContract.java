package menu;

import data.models.Contact;

import java.util.List;

/**
 * Created by krishnakandula on 1/21/17.
 */
public interface MenuContract {
    interface View {
        void showMainMenu();
        void showContactList();
        void showContactListOptions();
    }

    interface Presenter {
        void onMainMenuOptionSelected(int option);
        void getContactList();
        void onContactListOptionSelected(int option);
        void addContact(int listIndex);

        interface ContactListListener {
            void onContactListLoaded(List<Contact> contactList);
        }
    }
}
