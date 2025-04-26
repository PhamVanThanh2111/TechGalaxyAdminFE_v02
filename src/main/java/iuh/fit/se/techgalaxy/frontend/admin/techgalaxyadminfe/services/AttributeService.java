package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.AttributeRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.AttributeValueRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.AttributeValueUpdateRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.AttributeResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.ValueResponse;

import java.util.List;

public interface AttributeService {
    DataResponse<ValueResponse> getAttributesByVariantId(String variantId);

    DataResponse<AttributeResponse> getAllAttribute();

    DataResponse<AttributeResponse> getAttributeById(String id);

    DataResponse<Object> createAttributeValueByVariantId(String variantId, List<AttributeValueRequest> values, String accessToken);

    DataResponse<ValueResponse> updateValueProductVariant(String variantId, AttributeValueUpdateRequest attributeValueRequest, String accessToken);

    DataResponse<ValueResponse> deleteValue(String valueId, String accessToken);

    DataResponse<ValueResponse> getValueById(String valueId);

    DataResponse<ValueResponse> getValueByNameAtribute(String name);

	DataResponse<AttributeResponse> createAttribute(AttributeRequest request,String accessToken);
    DataResponse<ValueResponse> deleteAttribute(String attributeId, String accessToken);

}
