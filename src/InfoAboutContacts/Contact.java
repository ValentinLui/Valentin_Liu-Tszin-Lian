package InfoAboutContacts;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private boolean sex;
    private String citizenship;
    private FamilyStatus familyStatus;
    private String webSite;
    private String email;
    private String work;
    private String phone;
    private Address address;
    public void setAddress(String Country, String City,String Street, int HouseOrFlat,int index){
        address.setCountry(Country);
        address.setCity(City);
        address.setStreet(Street);
        address.setHouseOrFlat(HouseOrFlat);
        address.setIndex((short) index);
    }
}
