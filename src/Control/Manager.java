package Control;
import Exceptions.NotEnoughInformation;
import Exceptions.NotFoundObject;
import Exceptions.ObjectAlreadyCreated;
import InfoAboutContacts.Contact;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Manager {
    private static final Logger log = Logger.getLogger(String.valueOf(Manager.class));
    private ArrayList<Contact> contactList;
    private Manager() throws IOException {
        contactList = new ArrayList<Contact>();
        new File("ContactList").mkdirs();
    }
    private static  Manager singleton;
    public static Manager getInstance() throws ObjectAlreadyCreated, IOException {
        if (singleton == null) {
            singleton = new Manager();
        } else {
            throw new ObjectAlreadyCreated("Данный объект уже создан!");
        }
        return singleton;
    }
    public void AddContact(Contact contact){
        contactList.add(contact);
        try(FileWriter writer = new FileWriter("ContactList/"+contact.getName()+".txt", false ) )
        {
            writer.write("Name: "+contact.getName()
                    +"\nSurname: "+contact.getSurname()
                    +"\nPatronymic: "+contact.getPatronymic()
                    +"\nBirthDay: "+contact.getDayOfBirth()+"."+contact.getMonthOfBirth()+"."+contact.getYearOfBirth()
                    +"\nSex: "+contact.isSex()
                    +"\nCitizenship: "+contact.getCitizenship()
                    +"\nFamilyStatus: "+contact.getFamilyStatus()
                    +"\nWebSite: "+contact.getWebSite()
                    +"\nEmail: " +contact.getEmail()
                    +"\nWork: "+contact.getWork()
                    +"\nAddress: "+contact.getAddress());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        log.info("Добавляем контакт в записную книжку!");
    }
    public void RemoveContact(String Name) throws NotFoundObject {
        for(Contact contact:contactList){
            if(contact.getName().equals(Name)){
                new File("ContactList/"+contact.getName()+".txt").delete();
                contactList.remove(contact);
                log.info("Удаляем контакт в записную книжку!");
                break;
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
