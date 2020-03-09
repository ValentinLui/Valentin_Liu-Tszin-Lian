package InfoAboutContacts;

import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int idAddress;
    private String country;
    private String city;
    private String street;
    private int houseOrFlat;
    private short index;
}
