package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.Account;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.enumeration.CustomerStatus;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.enumeration.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse {
    String id;
    CustomerStatus userStatus;
    String name;
    String phone;
    Gender gender;
    String avatar;
    LocalDate dateOfBirth;
    Account account;
}
