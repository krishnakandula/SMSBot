package data;

import com.sun.istack.internal.NotNull;
import data.models.Contact;
import java.util.List;

/**
 * Created by krishnakandula on 1/20/17.
 */
public interface RepositoryContract {
    void getContact(int listIndex, ContactLoadedCallback callback);
    void getContactList(ContactListLoadedCallback callback);

    void addContact(Contact contact);
    boolean deleteContact(int listIndex);

    interface ContactLoadedCallback {
        void onContactLoaded(@NotNull Contact contact);
    }

    interface ContactListLoadedCallback {
        void onContactListLoaded(@NotNull List<Contact> contactList);
    }
}
