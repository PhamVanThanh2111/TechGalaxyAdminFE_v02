package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AttributeResponse {
	String id;
	String name;
	String type;
}
