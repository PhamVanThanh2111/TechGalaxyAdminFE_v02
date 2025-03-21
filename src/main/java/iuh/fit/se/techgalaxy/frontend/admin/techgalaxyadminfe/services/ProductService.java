package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.ProductDetailUpdateRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.ProductRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.ProductVariantDetailRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.ProductVariantRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.*;

import java.util.List;

public interface ProductService {
    DataResponse<ProductResponse> getProductById(String productId);

    DataResponse<ProductResponse> getAllProducts(String accessToken);

    DataResponse<ProductVariantResponse> getVariantById(String variantId);

    DataResponse<ProductDetailResponse> getVariantDetailById(String detailId);

    DataResponse<ProductResponse> createProduct(ProductRequest productRequest, String accessToken);

    DataResponse<ProductVariantResponse> createVariant(String productId, ProductVariantRequest variantRequest, String accessToken);

    DataResponse<String> createVariantDetail(String variantId, List<ProductVariantDetailRequest> detailRequest, String accessToken);

    DataResponse<ProductResponse> updateProduct(String productId, ProductRequest productRequest, String accessToken);

    DataResponse<ProductVariantResponse> updateVariant(String variantId, ProductVariantRequest variantRequest, String accessToken);

    DataResponse<Boolean> updateVariantDetail(String detailId, ProductDetailUpdateRequest detailRequest, String accessToken);

    DataResponse<Object> deleteProduct(String productId, String accessToken);

    DataResponse<Object> deleteVariant(String variantId, String accessToken);

    DataResponse<Object> deleteVariantDetail(String detailId, String accessToken);

    DataResponse<ProductVariantResponse> getAllProductVariantsByProductId(String productId);

    DataResponse<ProductVariantDetailResponse> getAllVariantDetailsByVariantId(String variantId);

    DataResponse<ProductVariantResponse> getAllVariants();

    DataResponse<ProductVariantResponse> findProductVariantByProductVariantDetailId(String detailId);

    DataResponse<ProductDetailResponse> findProductVariantDetailByProductVariantAndColorAndMemory(String productVariantId, String color, String memory);
}
