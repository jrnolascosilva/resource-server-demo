package systems.nolasco.portafolio.resourceserverdemo.model;

import jakarta.persistence.*;
import lombok.*;
import systems.nolasco.portafolio.resourceserverdemo.model.enums.ProductStatus;
import systems.nolasco.portafolio.resourceserverdemo.model.request.ProductRequest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"code"})
@Entity
@Table(name = "products")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "code",nullable = false)
	private String code;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	@Enumerated(EnumType.STRING)
	private ProductStatus status;
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
	public static Product toProduct(ProductRequest productRequest)
	{
		return Product.builder()				
				.code(productRequest.getCode())
				.createdAt(LocalDateTime.now())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.status(productRequest.getStatus())
				.build();
	}
	
	public static Product update(Product product, ProductRequest productRequest)
	{
		product.setCode(productRequest.getCode());
		//product.setUpdatedAt(LocalDateTime.now());
		product.setDescription(productRequest.getDescription());
		product.setPrice(productRequest.getPrice());
		product.setStatus(productRequest.getStatus());
		return product;		
	}
}
