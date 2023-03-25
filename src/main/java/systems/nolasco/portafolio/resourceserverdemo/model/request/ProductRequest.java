package systems.nolasco.portafolio.resourceserverdemo.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import systems.nolasco.portafolio.resourceserverdemo.model.enums.ProductStatus;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
	private String code;
	private String name;
	private String description;
	private BigDecimal price;
	private ProductStatus status;
}
