import Control.Manager;
import Exceptions.NotEnoughInformation;
import Exceptions.NotFoundObject;
import Exceptions.ObjectAlreadyCreated;
import InfoAboutContacts.Contact;
import InfoAboutContacts.ContactBuilder;
import util.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static InfoAboutContacts.FamilyStatus.FREE;

public class Main {
    public static void main(String[] argc) throws IOException, ObjectAlreadyCreated, NotFoundObject, SQLException, NotEnoughInformation {
        Manager manager= Manager.getInstance();
        System.out.println(manager.FindByName("Антон").toString());
        System.out.println(manager.FindByName("Валентин").toString());
        System.out.println(manager.maxId);
        System.out.println(manager.maxAddressId);
        ContactBuilder contactBuilder= new ContactBuilder();
        contactBuilder.setName("Андрей");
        contactBuilder.setSurname("Пупкин");
        contactBuilder.setId();
        manager.AddContact(contactBuilder.getContact());
        
        /*try {
            Controller Manager = new Controller();
            Contact FindUser = Manager.getUserInfoById(2);
            System.out.println(FindUser);
            ArrayList<Contact> arrayList = new ArrayList<Contact>();
            Manager.getContacts(arrayList);
            System.out.println(arrayList.get(0));

            //System.out.println(arrayList.get(1));
            //System.out.println(arrayList.get(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }
}
