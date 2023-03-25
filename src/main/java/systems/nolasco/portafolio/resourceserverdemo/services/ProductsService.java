package systems.nolasco.portafolio.resourceserverdemo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import systems.nolasco.portafolio.resourceserverdemo.model.Product;
import systems.nolasco.portafolio.resourceserverdemo.model.ProductNotFoundException;
import systems.nolasco.portafolio.resourceserverdemo.model.request.ProductRequest;
import systems.nolasco.portafolio.resourceserverdemo.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {

	private final ProductRepository productRepo;

	public List<Product> findAll() {
		return productRepo.findAll();
	}

	public Product findById(Long id) {
		return productRepo.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
	}

	public Product save(ProductRequest productRequest) {
		Product newProduct = Product.toProduct(productRequest);
		return productRepo.save(newProduct);
	}

	public Product update(Long id, ProductRequest productRequest) {
		Product currentProduct = findById(id);

		Product updatedProduct = Product.update(currentProduct, productRequest);

		return productRepo.save(updatedProduct);
	}
	
	public void delete(Long id) {
		Product currentProduct = findById(id);

		productRepo.delete(currentProduct);
	}

}
