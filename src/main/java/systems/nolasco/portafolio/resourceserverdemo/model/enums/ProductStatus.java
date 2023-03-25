package systems.nolasco.portafolio.resourceserverdemo.model.enums;

import lombok.Getter;

@Getter
public enum ProductStatus {
	OK("OK"), OUT_OF_STOCK("Out of Stock"), OBSOLETE("Obsolete");
	
	private String descr;
	ProductStatus(String descr) {
		this.descr = descr;
	}
}
