package Control;
import Exceptions.NotFoundObject;
import Exceptions.ObjectAlreadyCreated;
import InfoAboutContacts.Contact;
import lombok.Getter;
import lombok.ToString;
import util.Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

@ToString
@Getter
public class Manager {
    private static final Logger log = Logger.getLogger(String.valueOf(Manager.class));
    private Controller controller;
    private ArrayList<Contact> contactList;
    private ArrayList<Integer> poolFreeId;
    public static int maxId;
    public static int maxAddressId;
    private Manager() throws IOException, SQLException {
        contactList = new ArrayList<Contact>();
        poolFreeId = new ArrayList<Integer>();
        controller = new Controller();
        controller.getContacts(this.contactList, this.poolFreeId);
        for (Contact contact:contactList) {
            if(contact.getId()>maxId)
                maxId=contact.getId();
        }
        for (Integer id:poolFreeId) {
            if(id>maxId)
                maxId=id;
        }
    }
    private static  Manager singleton;
    public static Manager getInstance() throws ObjectAlreadyCreated, IOException, SQLException {
        if (singleton == null) {
            singleton = new Manager();
        } else {
            throw new ObjectAlreadyCreated("Данный объект уже создан!");
        }
        return singleton;
    }
    public void AddContact(Contact contact) throws SQLException {
        contactList.add(contact);
        controller.addContact(contact);
        log.info("Добавляем контакт в записную книжку!");
    }
    public void RemoveContact(String Name) throws NotFoundObject, SQLException {
        for(Contact contact:contactList){
            if(contact.getName().equals(Name)){
                controller.deleteContact(contact.getId());
                contactList.remove(contact);
                log.info("Удаляем контакт из записной книжки!");
                return;
            }
        }
        throw new NotFoundObject("Не найден, указанный вами, объект!");
    }
    public Contact FindByName(String Name) throws NotFoundObject { //доделать если таких контактов несколько
        for(Contact contact:contactList){
            if(contact.getName().equals(Name) || Name.contains(contact.getName())){
                log.info("Контакт найден!");
                return  contact;
            }
        }
        throw new NotFoundObject("Не найден, указанный вами, объект!");
    }
    public ArrayList<Contact> getCollection(){
        return this.contactList;
    }
}
