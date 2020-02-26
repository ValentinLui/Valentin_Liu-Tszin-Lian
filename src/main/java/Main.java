package main.java;

import Control.Manager;
import Exceptions.NotEnoughInformation;
import Exceptions.NotFoundObject;
import Exceptions.ObjectAlreadyCreated;
import InfoAboutContacts.Contact;
import InfoAboutContacts.ContactBuilder;
import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(String.valueOf(Main.class));
    public static void main(String[] argc) throws IOException, ObjectAlreadyCreated, NotFoundObject, NotEnoughInformation {
        log.info("Это информациооное сообщение!");
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
