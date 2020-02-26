package InfoAboutContacts;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {
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
    private Address address;
}
