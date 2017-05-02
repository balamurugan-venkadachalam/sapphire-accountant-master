package ae.kbgroup.sapphire.domain.repository;

import ae.kbgroup.sapphire.domain.model.MCategory;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepository extends JpaRepository<MCategory, Long>{

	List<MCategory> findByCategoryNameIgnoreCase(String categoryName);
	
	Stream<MCategory> findByIsActive(String categoryName);
}
