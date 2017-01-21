package data;

import data.models.Contact;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishnakandula on 1/20/17.
 */
public class ContactRepository implements BaseRepository {
    private ArrayList<Contact> contactList;
    private static ContactRepository contactRepository;

    private ContactRepository(){
        contactList = new ArrayList<Contact>();
    }

    public static ContactRepository getContactRepository(){
        if(contactRepository == null)
            contactRepository = new ContactRepository();
        return contactRepository;
    }

    public void getContact(int listIndex, ContactLoadedCallback callback) {
         callback.onContactLoaded(contactList.get(listIndex));
    }

    public void getContactList(ContactListLoadedCallback callback) {
        callback.onContactListLoaded(contactList);
    }

    public void addContact(Contact contact) {
        contact.setId(generateRandomId());
        contactList.add(contact);
    }

    public boolean deleteContact(int listIndex) {
        contactList.remove(listIndex);
        return true;
    }

    //TODO: Fix randomizer so two elements don't get the same id
    private static int generateRandomId(){
        int min = 0; int max = 100000;
        int id = (int) ((Math.random() * (max - min)) + min);
        return id;
    }
}
