package menu;

import config.Config;
import data.RepositoryContract;
import data.ContactRepository;
import data.models.Contact;
import service.ServiceContract;

import java.util.List;

/**
 * Created by krishnakandula on 1/21/17.
 */
public class MenuPresenter implements MenuContract.Presenter{
    private MenuContract.View view;
    private ServiceContract smsService;
    private int selectedContactIndex;

    protected MenuPresenter(MenuContract.View view, ServiceContract smsService){
        this.view = view;
        this.smsService = smsService;
        selectedContactIndex = -1;
    }

    public List<Contact> getContactList() {
        return ContactRepository.getContactRepository().getContactList();
    }

    public void addContact(String name, String phoneNumber) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);

        ContactRepository.getContactRepository().addContact(contact, new RepositoryContract.OnAddContactListener() {
            public void onAdded() {
                //Do nothing
            }
        });
        view.showMainMenu();
    }

    public void setSelectedContact(int selectedContactIndex) {
        List<Contact> contactList = ContactRepository.getContactRepository().getContactList();
        if(selectedContactIndex < 0 || selectedContactIndex >= contactList.size()){
            view.displayToast("Please select a valid contact.");
            view.showContactListOptions();
        } else {
            this.selectedContactIndex = selectedContactIndex;
            view.showContactOptions();
        }
    }

    public void deleteContact() {
        ContactRepository.getContactRepository()
                .deleteContact(selectedContactIndex, new RepositoryContract.OnDeleteContactListener() {
                    public void onDeleted() {
                        //Update view's contact list
                    }
                });
        view.showContactList();
    }

    public void sendMessage(String message) {
        Contact contact = ContactRepository.getContactRepository().getContact(selectedContactIndex);
        smsService.sendMessage(Config.TWILIO_FROM_PHONE_NUMBER, Config.MY_PHONE_NUMBER, message);
        view.showContactOptions();
    }

    public void onMainMenuOptionSelected(int option) {
        switch (option){
            case 1:
                onShowContactListOptions();
                break;
            case 2:
                view.addContact();
                break;
            default: return;
        }
    }

    private void onShowContactListOptions(){
        if(ContactRepository.getContactRepository().getContactList().isEmpty()){
            view.displayToast("The Contact list is empty.");
            view.showMainMenu();
        } else {
            view.showContactList();
            view.showContactListOptions();
        }
    }

    public void onContactListOptionSelected(int option) {
        switch (option) {
            case 1:
                view.selectContact();
            default:
                view.showMainMenu();
                break;
        }
    }

    public void onContactOptionsSelected(int option) {
        switch (option){
            case 1:
                view.showMessageTextView();
                break;
            case 2:
                deleteContact();
                break;
            default:
                view.showMainMenu();
                break;
        }
    }
}
