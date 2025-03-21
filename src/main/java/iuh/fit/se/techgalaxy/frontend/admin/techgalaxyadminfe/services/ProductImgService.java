package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.ProductsImageRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.ProductsImageResponse;

import java.util.List;

public interface ProductImgService {
    public DataResponse<ProductsImageResponse> createProductImg(String variantDetail, List<ProductsImageRequest> productsImageRequest, String accessToken);
}
