package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.enumeration.ProductStatus;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariantRequest_FE {
    @NotBlank(message = "Name is required")
    String name;

    String description;

    String content;

    MultipartFile avatar;

    @NotNull(message = "Please choose whether featured or not")
    Boolean featured;

    @NotNull(message = "Status is required")
    ProductStatus status;

    @NotBlank(message = "Usage Category is required")
    String usageCategoryId;
}
