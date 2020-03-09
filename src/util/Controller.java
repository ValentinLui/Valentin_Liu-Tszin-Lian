package util;
import Control.Manager;
import InfoAboutContacts.Address;
import InfoAboutContacts.Contact;

import java.sql.*;
import java.util.ArrayList;

public class Controller {
    private final static String SQL_GET_USERINFO = "select * from contacts";
    private final static String SQL_GET_ADDRESS = "select * from address";
    private final static String SQL_ADD_USER = "INSERT contacts(idContacts, Name, Surname, patronymic, dayOfBirth, monthOfBirth, yearOfBirth, sex, citizenship, familyStatus, webSite, email, work, phone) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final static String SQL_ADD_ADDRESS = "INSERT  address(idAddress, country, city, street, flatOrHouse,homeIndex) VALUES(?,?,?,?,?,?)";
    private final static String SQL_GET_FREEID = "select * from freeid";
    private final static String SQL_DELETE_USER_BY_ID = "DELETE FROM contacts WHERE idcontacts = ? ";
    private final static String SQL_ADD_FREE_ID= "INSERT freeid(freeid) VALUES(?)";
    private Connection connection;
    private Contact user;

    public Controller() throws SQLException {
        this.connection = ConnectorDB.getConnection();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public void getContacts(ArrayList<Contact> contactList,ArrayList<Integer> poolFreeId) {
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        try {
            ps = connection.prepareStatement(SQL_GET_USERINFO);
            ResultSet rs = ps.executeQuery();
            ArrayList<Integer> idAddresses= new ArrayList<Integer>();
            while (rs.next()) {
                Contact resultSetUser = new Contact();
                resultSetUser.setId(rs.getInt(1));
                resultSetUser.setName(rs.getString(2));
                resultSetUser.setSurname(rs.getString(3));
                resultSetUser.setPatronymic(rs.getString(4));
                resultSetUser.setDayOfBirth(rs.getInt(5));
                resultSetUser.setMonthOfBirth(rs.getInt(6));
                resultSetUser.setYearOfBirth(rs.getInt(7));
                resultSetUser.setSex(rs.getBoolean(8));
                resultSetUser.setCitizenship(rs.getString(9));
                //resultSetUser.setFamilyStatus(rs.getInt(10));
                resultSetUser.setWebSite(rs.getString(11));
                resultSetUser.setEmail(rs.getString(12));
                resultSetUser.setWork(rs.getString(13));

                idAddresses.add(rs.getInt(15));
                contactList.add(resultSetUser);
            }

            ps = connection.prepareStatement(SQL_GET_ADDRESS);
            rs = ps.executeQuery();
            while(rs.next()){
                Address address = new Address();
                address.setCountry(rs.getString(2));
                address.setCity(rs.getString(3));
                address.setStreet(rs.getString(4));
                address.setHouseOrFlat(rs.getInt(5));
                address.setIndex((short) rs.getInt(6));
                for(Integer idAddress: idAddresses){
                    if(rs.getInt(1)==idAddress)
                        for(Contact contact: contactList)
                            contact.setAddress(address);
                }
            }

            ps = connection.prepareStatement(SQL_GET_ADDRESS);
            rs = ps.executeQuery();
            while (rs.next()) {
                if(Manager.maxAddressId<rs.getInt(1))
                    Manager.maxAddressId=rs.getInt(1);
            }
            ps = connection.prepareStatement(SQL_GET_FREEID);
            rs = ps.executeQuery();
            while (rs.next()) {
                poolFreeId.add(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }

    public void addContact(Contact contact) throws SQLException {
        PreparedStatement  ps = connection.prepareStatement(SQL_ADD_ADDRESS);
        ps.setString(1, String.valueOf(Manager.maxAddressId));
        ps.setString(2, String.valueOf(contact.getAddress().getCountry()));
        ps.setString(3, String.valueOf(contact.getAddress().getCity()));
        ps.setString(4, String.valueOf(contact.getAddress().getStreet()));
        ps.setString(5, String.valueOf(contact.getAddress().getHouseOrFlat()));
        ps.setString(6, String.valueOf(contact.getAddress().getIndex()));
        ps.executeUpdate();

        ps = connection.prepareStatement(SQL_ADD_USER);
        ps.setString(1, String.valueOf(contact.getId()));
        ps.setString(2, String.valueOf(contact.getName()));
        ps.setString(3, String.valueOf(contact.getSurname()));
        ps.setString(4, String.valueOf(contact.getPatronymic()));
        ps.setString(5, String.valueOf(contact.getDayOfBirth()));
        ps.setString(6, String.valueOf(contact.getMonthOfBirth()));
        ps.setString(7, String.valueOf(contact.getYearOfBirth()));
        ps.setString(8, String.valueOf(1));
        ps.setString(9, String.valueOf(contact.getCitizenship()));
        ps.setString(10, String.valueOf(0));
        ps.setString(11, String.valueOf(contact.getWebSite()));
        ps.setString(12, String.valueOf(contact.getEmail()));
        ps.setString(13, String.valueOf(contact.getWork()));
        ps.setString(14, String.valueOf(contact.getPhone()));
        ps.executeUpdate();
    }


    public void deleteContact(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SQL_DELETE_USER_BY_ID);
        ps.setString(1, String.valueOf(id));
        ps.executeUpdate();
        ps = connection.prepareStatement(SQL_ADD_FREE_ID);
        ps.setString(1, String.valueOf(id));
        ps.executeUpdate();
    }
}
