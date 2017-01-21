package menu;

import com.sun.istack.internal.NotNull;
import data.RepositoryContract;
import data.ContactRepository;
import data.models.Contact;

import java.util.List;

/**
 * Created by krishnakandula on 1/21/17.
 */
public class MenuPresenter implements MenuContract.Presenter{
    private MenuContract.View view;

    protected MenuPresenter(MenuContract.View view){
        this.view = view;
    }

    public void onMainMenuOptionSelected(int option) {
        switch (option){
            case 1:
                view.showContactList();
                break;
            case 2:
                view.addContact();
                break;
            default: return;
        }
    }

    public void getContactList(final OnContactListLoadedListener listener) {
        ContactRepository.getContactRepository().getContactList(new RepositoryContract.ContactListLoadedCallback() {
            public void onContactListLoaded(@NotNull List<Contact> contactList) {
                listener.onListLoaded(contactList);
            }
        });
    }

    public void onContactListOptionSelected(int option) {
        switch (option) {
            default:
                view.showMainMenu();
                break;
        }
    }

    public void addContact(String name, String phoneNumber) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);

        ContactRepository.getContactRepository().addContact(contact);
        view.showMainMenu();
    }
}
