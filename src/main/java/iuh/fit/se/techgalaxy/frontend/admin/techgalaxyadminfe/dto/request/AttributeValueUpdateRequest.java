package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class AttributeValueUpdateRequest {
    @NotBlank(message = "ID is required")
    String id;

    @NotBlank(message = "Value is required")
    String value;

    @NotBlank(message = "Attribute ID is required")
    String attributeId;
    
}
