package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class ValueResponse {
    String id;
    String attributeName;
    String attributeId;
    String value;
}