package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.enumeration.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariantResponse {
    String id;
    String name;
    String description;
    String content;
    String avatar;
    Boolean featured;
    ProductStatus status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    UsageCategoryResponse usageCategory;
    List<ProductVariantDetailResponse> productVariantDetails;
}