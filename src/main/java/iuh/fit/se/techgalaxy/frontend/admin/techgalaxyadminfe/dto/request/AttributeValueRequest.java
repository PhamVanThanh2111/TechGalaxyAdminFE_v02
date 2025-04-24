package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class AttributeValueRequest {

    @Size(min = 5, max = 24, message = "value invalid")
    @NotBlank(message = "Attribute must be selected")
    String value;
    @NotBlank(message = "Value cannot be empty")
    String attributeId;
    
}
