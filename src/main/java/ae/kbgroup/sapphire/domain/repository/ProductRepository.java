package ae.kbgroup.sapphire.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ae.kbgroup.sapphire.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
