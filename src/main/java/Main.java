package main.java;
import Control.Manager;
import Exceptions.NotEnoughInformation;
import Exceptions.ObjectAlreadyCreated;
import InfoAboutContacts.Contact;
import InfoAboutContacts.ContactBuilder;
import java.io.IOException;

public class Main {
    public static void main(String[] argc) throws IOException, ObjectAlreadyCreated, NotEnoughInformation {
        Manager manager= Manager.getInstance();
        ContactBuilder builder = new ContactBuilder();
        builder.setName("Валик");
        builder.setPatronymic("Владимирович");
        builder.setSurname("Лю");
        builder.setAddress();
        Contact contact = builder.getContact();
        manager.AddContact(contact);
    }
}
