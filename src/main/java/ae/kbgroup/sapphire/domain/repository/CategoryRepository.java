package ae.kbgroup.sapphire.domain.repository;

import ae.kbgroup.sapphire.domain.model.Category;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepository extends JpaRepository<Category, Long>{

	List<Category> findByCategoryNameIgnoreCase(String categoryName);
	
	Stream<Category> findByIsActive(String categoryName);
}
