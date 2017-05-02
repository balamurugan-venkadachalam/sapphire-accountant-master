package ae.kbgroup.sapphire.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ae.kbgroup.sapphire.domain.model.MProduct;

public interface ProductRepository extends JpaRepository<MProduct, Long>{

}
