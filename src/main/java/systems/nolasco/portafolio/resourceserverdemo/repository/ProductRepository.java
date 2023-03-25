package systems.nolasco.portafolio.resourceserverdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import systems.nolasco.portafolio.resourceserverdemo.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
