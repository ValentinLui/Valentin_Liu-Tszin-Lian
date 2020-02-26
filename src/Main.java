import Control.Manager;
import Exceptions.NotEnoughInformation;
import Exceptions.NotFoundObject;
import Exceptions.ObjectAlreadyCreated;
import InfoAboutContacts.Contact;
import InfoAboutContacts.ContactBuilder;
import java.io.IOException;

public class Main {
    public static void main(String[] argc) throws IOException, ObjectAlreadyCreated, NotFoundObject, NotEnoughInformation {
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
