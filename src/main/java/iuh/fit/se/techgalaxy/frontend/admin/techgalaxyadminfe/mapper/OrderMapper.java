package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.mapper;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.OrderRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.OrderResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    /**
     * @param orderResponse
     * @return Order
     * author: PhamVanThanh
     */
    Order toOrderFromResponse(OrderResponse orderResponse);

    /**
     * @param orderRequest
     * @return Order
     * author: PhamVanThanh
     */
    Order toOrderFromRequest(OrderRequest orderRequest);

    /**
     * @param order
     * @return OrderResponse
     * author: PhamVanThanh
     */
    OrderResponse toOrderResponse(Order order);

    /**
     * @param order
     * @return OrderRequest
     * author: PhamVanThanh
     */
    OrderRequest toOrderRequest(Order order);
}
