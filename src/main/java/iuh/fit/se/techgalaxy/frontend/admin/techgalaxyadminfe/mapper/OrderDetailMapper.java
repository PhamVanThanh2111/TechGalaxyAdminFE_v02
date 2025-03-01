package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.mapper;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.OrderDetailRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.OrderDetailResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

    OrderDetailResponse toOrderDetailResponse(OrderDetail orderDetail);

    OrderDetailRequest toOrderDetailRequest(OrderDetail orderDetail);

    OrderDetail toOrderDetailFromRequest(OrderDetailRequest orderDetailRequest);

    OrderDetail toOrderDetailFromResponse(OrderDetailResponse orderDetailResponse);
}
