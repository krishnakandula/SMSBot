package data;

import data.models.Contact;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishnakandula on 1/20/17.
 */
public class ContactRepository implements RepositoryContract {
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

    public Contact getContact(int listIndex) {
        return contactList.get(listIndex);
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void addContact(Contact contact, OnAddContactListener listener) {
        contact.setId(generateRandomId());
        contactList.add(contact);
        //Add contact to database
    }

    public void deleteContact(int listIndex, OnDeleteContactListener listener) {
        contactList.remove(listIndex);
        //Delete contact from database
        listener.onDeleted();
    }

    //TODO: Fix randomizer so two elements don't get the same id
    private static int generateRandomId(){
        int min = 0; int max = 100000;
        int id = (int) ((Math.random() * (max - min)) + min);
        return id;
    }
}
