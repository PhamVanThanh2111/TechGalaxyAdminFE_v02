package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.mapper;


import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.ProductVariantRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.ProductVariantResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.ProductVariant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductVariantMapper {
    ProductVariantResponse toProductVariantResponse(ProductVariant productVariant);

    ProductVariant toProductVariant(ProductVariantRequest productVariantRequest);

    void updateProductVariantFromRequest(@MappingTarget ProductVariant productVariant, ProductVariantRequest productVariantRequest);
}
