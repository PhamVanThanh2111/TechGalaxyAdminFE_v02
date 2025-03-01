package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrademarkRequest {
    String id;
    String name;
}
