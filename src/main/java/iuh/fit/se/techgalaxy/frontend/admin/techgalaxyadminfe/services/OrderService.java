package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.OrderRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.OrderResponse;

public interface OrderService {
    DataResponse<OrderResponse> getAll(String accessToken);

    DataResponse<OrderResponse> create(OrderRequest orderRequest, String accessToken);

    DataResponse<OrderResponse> getById(String id, String accessToken);

    DataResponse<OrderResponse> update(OrderRequest orderRequest, String accessToken);
}
