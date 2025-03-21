package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.OrderDetailRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.OrderDetailResponse;

public interface OrderDetailService {
    DataResponse<OrderDetailResponse> getOrderDetail(String orderId, String accessToken);

    DataResponse<OrderDetailResponse> createOrderDetail(OrderDetailRequest orderDetailRequest, String accessToken);

    DataResponse<OrderDetailResponse> updateOrderDetail(String id, OrderDetailRequest orderDetailRequest, String accessToken);

    DataResponse<OrderDetailResponse> getOrderDetailByOrderIdAndProductVariantDetailId(String orderId, String productVariantDetailId, String accessToken);
}
