package systems.nolasco.portafolio.resourceserverdemo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import systems.nolasco.portafolio.resourceserverdemo.model.Product;
import systems.nolasco.portafolio.resourceserverdemo.services.ProductsService;
import systems.nolasco.portafolio.resourceserverdemo.model.request.ProductRequest;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class ProductController {
	private final ProductsService productService;
	
	@GetMapping("public")
	public ResponseEntity<List<Product>> getPublicAllProducts()
	{
		log.info("Public: Finding all products ...");
		return new ResponseEntity<>(productService.findAll(),	HttpStatus.OK);
		
	}

	@GetMapping("private")
	public ResponseEntity<List<Product>> getPrivateAllProducts()
	{
		log.info("Private: Finding all products ...");
		return new ResponseEntity<>(productService.findAll(),	HttpStatus.OK);
	}

	@GetMapping("private-scoped")
	public ResponseEntity<List<Product>> getPrivateScopedAllProducts()
	{
		log.info("Private Scoped: Finding all products ...");
		return new ResponseEntity<>(productService.findAll(),	HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<Product> findProductById(@PathVariable Long id)
	{
		return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest)
	{
		Product newProduct = productService.save(productRequest);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("{id}")
					.buildAndExpand(newProduct.getId())
					.toUri();
		
		return ResponseEntity.created(location).body(newProduct);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest)
	{
		productService.update(id, productRequest);
		
		return ResponseEntity.noContent().build();		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id)
	{
		productService.delete(id);
		
		return ResponseEntity.noContent().build();		
	}


}
