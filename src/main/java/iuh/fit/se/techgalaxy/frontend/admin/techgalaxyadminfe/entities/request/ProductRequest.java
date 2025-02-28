package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
     String id;
     @Size(min = 5, max = 24, message = "PRODUCT_NAME_INVALID")
     String name;
     String trademarkId;
}
