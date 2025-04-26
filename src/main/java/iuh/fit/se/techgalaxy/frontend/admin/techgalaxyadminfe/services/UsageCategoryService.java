package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.UsageCategoryRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.UsageCategoryResponse;

public interface UsageCategoryService {
    DataResponse<UsageCategoryResponse> getAllUsageCategories();

    DataResponse<UsageCategoryResponse> getUsageCategoryById(String id);
    DataResponse<UsageCategoryResponse> createUsageCategory(UsageCategoryRequest usageCategory, String accessToken);
    DataResponse<UsageCategoryResponse> updateUsageCategory(String id,UsageCategoryRequest usageCategory, String accessToken);
    DataResponse<UsageCategoryResponse> deleteUsageCategory(String id, String accessToken);

}
