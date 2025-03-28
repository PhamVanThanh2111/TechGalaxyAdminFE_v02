package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.mapper;


import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.ProductRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.ProductResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toProductResponse(Product product);

    void updateProductFromRequest(@MappingTarget Product product, ProductRequest productRequest);
}
