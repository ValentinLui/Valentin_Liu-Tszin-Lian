package InfoAboutContacts;

import Control.Manager;
import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class Address {
    public int idAddress;
    private String country;
    private String city;
    private String street;
    private int houseOrFlat;
    private short index;
    public Address(String Country, String City, String Street, int HouseOrFlat, short Index){
        idAddress= Manager.maxAddressId+1;
        Manager.maxAddressId++;
        country=Country;
        city=City;
        street=Street;
        houseOrFlat=HouseOrFlat;
        index=Index;
        if(country==null)
            country="-";
        if(city==null)
            city="-";
        if(street==null)
            street="-";
        if(index==0)
            index=1;

    }
}
