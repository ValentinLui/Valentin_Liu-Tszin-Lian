package InfoAboutContacts;

import Control.Manager;
import Exceptions.NotEnoughInformation;

import java.util.Date;
import java.util.logging.Logger;

public class ContactBuilder implements InfoAboutContacts.IContactBuilder {
    private static final Logger log = Logger.getLogger(String.valueOf(ContactBuilder.class));
    private int id;
    private String surname;
    private String patronymic;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private Date dateOfBirth;
    private boolean sex;
    private String citizenship;
    private FamilyStatus familyStatus;
    private String webSite;
    private String email;
    private String work;
    private Address address;
    private int idAddress= Manager.maxAddressId++;
    private String country;
    private String city;
    private String street;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;
    private int houseOfFlat;
    private short index;

    public void setId(){this.id=Manager.maxId+1;
    Manager.maxId++;}

    public void setIndex(short index) {
        this.index = index;
    }

    public void setHouseOfFlat(int houseOfFlat) {
        this.houseOfFlat = houseOfFlat;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public void setName(String Name) {
        this.name=Name;
    }
    public String getName() {
        return name;
    }

    private String name;

    public String getSurname() {
        return surname;
    }
    @Override
    public void setSurname(String Surname) {
        this.surname=Surname;
    }

    @Override
    public void setPatronymic(String Patronymic) {
        this.patronymic=Patronymic;
    }

    @Override
    public void setDayOfBirth(int Day) {
        this.dayOfBirth=Day;
    }

    @Override
    public void setMonthOfBirth(int Month) {
        this.monthOfBirth=Month;
    }

    @Override
    public void setYearOfBirth(int Year) {
        this.yearOfBirth=Year;
    }

    @Override
    public void setSex(boolean Sex) {
        this.sex=Sex;
    }

    @Override
    public void setCitizenship(String Citizenship) {
        this.citizenship=Citizenship;
    }

    @Override
    public void setFamilyStatus(FamilyStatus Status) {
        this.familyStatus=Status;
    }

    @Override
    public void setWebSite(String WebSite) {
        this.webSite=WebSite;
    }

    @Override
    public void setEmail(String Email) {
        this.email=Email;
    }

    @Override
    public void setWork(String Work) {
        this.work=Work;
    }

    @Override
    public void setAddress() {
        address=new Address(country,city,street, houseOfFlat, index);
    }
    public InfoAboutContacts.Contact getContact() throws NotEnoughInformation {
        if(getName()==null || getSurname()==null) {
            throw new NotEnoughInformation("Введите обязательные поля!");
        }
        log.info("Создается контакт!");
        return new Contact(id,name,surname,patronymic, dayOfBirth, monthOfBirth, yearOfBirth, sex, citizenship, familyStatus, webSite, email, work, phone, address);
    }
}
