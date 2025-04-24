package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request;

import jakarta.validation.constraints.*;
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
    @NotBlank(message = "Memory must be selected")
    private String memid;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price must be 0 or more")
    private Double price;

    @NotNull(message = "Sale is required")
    @DecimalMin(value = "0.0", message = "Sale must be >= 0")
    @DecimalMax(value = "100.0", message = "Sale must be <= 100")
    private Double sale;

    @NotEmpty(message = "At least one color must be added")
    private List<ColorRequest> colors;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class ColorRequest {
        @NotNull(message = "Quantity is required")
        @Min(value = 1, message = "Quantity must be at least 1")
        private Integer quantity;

        @NotBlank(message = "Color must be selected")
        private String colorId;

        private MultipartFile[] images;
    }
}
