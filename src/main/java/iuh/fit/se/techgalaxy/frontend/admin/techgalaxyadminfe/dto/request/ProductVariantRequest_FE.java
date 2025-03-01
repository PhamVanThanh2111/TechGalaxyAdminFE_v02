package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.enumeration.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariantRequest_FE {
    String name;
    String description;
    String content;
    MultipartFile avatar;
    Boolean featured;
    ProductStatus status;
    String usageCategoryId;
}
