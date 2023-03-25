package systems.nolasco.portafolio.resourceserverdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProductNotFoundException extends RuntimeException {
	private String message;
}
