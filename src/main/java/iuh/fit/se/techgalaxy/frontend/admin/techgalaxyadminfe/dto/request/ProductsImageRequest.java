package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductsImageRequest {
    String path;
    Boolean avatar;
}