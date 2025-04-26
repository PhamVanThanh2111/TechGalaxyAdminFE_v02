package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.ColorRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.Color;

public interface ColorService {
    DataResponse<Color> getAllColors();

    DataResponse<Color> getColorById(String id);
    DataResponse<Color> createColor(ColorRequest colorRequest, String accessToken);
    DataResponse<Color> deleteColor(String colorId, String accessToken);
    DataResponse<Color> updateColor(String colorId, ColorRequest color,String accessToken);
}
