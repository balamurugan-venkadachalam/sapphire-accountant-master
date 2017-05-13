package ae.kbgroup.spring.security.login;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;

import ae.kbgroup.sapphire.config.spring.SpringRootConfig;
import ae.kbgroup.sapphire.domain.model.Category;
import ae.kbgroup.sapphire.domain.repository.CategoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringRootConfig.class })
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
public class CategoryRepositoryTest extends BaseTest{
	

	
	@Autowired
	private CategoryRepository  categoryRepository;
	
	@Test
	public void testCategoryFindAll(){
		long count = categoryRepository.count();
		
		assertThat(count, is(equalTo(2l)));
	}

	@Test
	public void testCategoryFindByName(){
		List<Category> categories = categoryRepository.findByCategoryNameIgnoreCase("bear");
		
		assertThat(categories.size(), is(equalTo(1)));
	}
	
	
	@Test
	public void testCategoryFindById(){
		Category category = categoryRepository.findOne(101l);
		
		assertThat(category.getCategoryName(), is(equalTo("Bear")));
	}
}
