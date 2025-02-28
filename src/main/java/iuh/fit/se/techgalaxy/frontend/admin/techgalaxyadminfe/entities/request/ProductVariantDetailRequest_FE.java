package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariantDetailRequest_FE {
    String memid;

    Double price;

    Double sale;

    List<ColorRequest> colors = new ArrayList<>();

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class ColorRequest {
        int quantity;

        String colorId;

        MultipartFile[] images;
    }
}
