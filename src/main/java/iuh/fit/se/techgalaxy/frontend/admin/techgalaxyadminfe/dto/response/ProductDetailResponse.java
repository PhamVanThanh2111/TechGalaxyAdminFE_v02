package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.Color;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.Memory;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.ProductsImage;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.enumeration.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDetailResponse {
    String id;
    String productVariantId;
    Color color;
    Memory memory;
    Integer viewsCount = 0;
    Integer quantity;
    Double price;
    Double sale;
    ProductStatus status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    List<ProductsImage> productsImage;
}
