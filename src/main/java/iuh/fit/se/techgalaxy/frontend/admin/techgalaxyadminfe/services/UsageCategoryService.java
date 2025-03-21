package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.UsageCategoryResponse;

public interface UsageCategoryService {
    DataResponse<UsageCategoryResponse> getAllUsageCategories();

    DataResponse<UsageCategoryResponse> getUsageCategoryById(String id);

}
