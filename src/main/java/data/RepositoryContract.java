package data;

import data.models.Contact;
import java.util.List;

/**
 * Created by krishnakandula on 1/20/17.
 */
public interface RepositoryContract {
    Contact getContact(int listIndex);
    List<Contact> getContactList();

    void addContact(Contact contact, OnAddContactListener listener);
    void deleteContact(int listIndex, OnDeleteContactListener listener);

    interface OnAddContactListener {
        void onAdded();
    }

    interface OnDeleteContactListener {
        void onDeleted();
    }
}
