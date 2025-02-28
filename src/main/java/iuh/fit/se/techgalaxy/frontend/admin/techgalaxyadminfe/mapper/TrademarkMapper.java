package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.mapper;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.TrademarkRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.TrademarkResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.Trademark;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TrademarkMapper {
    TrademarkMapper INSTANCE = Mappers.getMapper(TrademarkMapper.class);

    TrademarkRequest toTrademarkRequest(Trademark trademark);

    TrademarkResponse toTrademarkResponse(Trademark trademark);

    Trademark toTrademarkFromRequest(TrademarkRequest trademarkRequest);

    Trademark toTrademarkFromResponse(TrademarkResponse trademarkResponse);
}
