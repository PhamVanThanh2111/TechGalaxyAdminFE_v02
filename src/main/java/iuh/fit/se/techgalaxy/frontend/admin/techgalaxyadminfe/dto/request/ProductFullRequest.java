package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ProductFullRequest {
    @Size(min = 5, max = 24, message = "PRODUCT_NAME_INVALID")
    String name;
    String trademarkId;
//    List<ProductVariantRequest> variants;
//
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    @FieldDefaults(level = AccessLevel.PRIVATE)
//    @ToString
//    public static class ProductVariantRequest {
//        String name;
//        String description;
//        String content;
//        MultipartFile avatar;
//        Boolean featured;
//        String usageCategoryId;
//        List<ProductVariantDetailRequest> details;
//
//        @Getter
//        @Setter
//        @NoArgsConstructor
//        @AllArgsConstructor
//        @FieldDefaults(level = AccessLevel.PRIVATE)
//        @ToString
//        public static class ProductVariantDetailRequest {
//            String memid;
//            Double price;
//            Double sale;
//            List<ColorRequest> colors;
//
//            @Getter
//            @Setter
//            @NoArgsConstructor
//            @AllArgsConstructor
//            @FieldDefaults(level = AccessLevel.PRIVATE)
//            @ToString
//            public static class ColorRequest {
//                String colorId;
//                Integer quantity;
//                MultipartFile[] images;
//            }
//        }
//    }
}
