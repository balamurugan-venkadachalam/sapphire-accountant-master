package ae.kbgroup.sapphire.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ae.kbgroup.sapphire.domain.model.MCategory;
import ae.kbgroup.sapphire.domain.model.MCountryOrigin;
import ae.kbgroup.sapphire.domain.model.MPack;
import ae.kbgroup.sapphire.domain.model.MProduct;
import ae.kbgroup.sapphire.domain.repository.CategoryRepository;
import ae.kbgroup.sapphire.domain.repository.CountryOriginRepository;
import ae.kbgroup.sapphire.domain.repository.PackRepository;
import ae.kbgroup.sapphire.domain.repository.ProductRepository;
import ae.kbgroup.sapphire.exception.CategoryNotFound;
import ae.kbgroup.sapphire.exception.CountryOriginNotFound;
import ae.kbgroup.sapphire.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CountryOriginRepository countryOriginRepository;
	
	@Autowired
	private PackRepository packRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	@Override
	public MCategory createCategory(MCategory category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(long id) throws CategoryNotFound {
		categoryRepository.delete(id);
	}

	@Override
	public List<MCategory> findAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public MCategory updateCategory(MCategory category) throws CategoryNotFound {
		return categoryRepository.save(category);
	}

	@Override
	public MCategory findByIdCategory(long id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public MCountryOrigin createCountryOrigin(MCountryOrigin countryOrgin) {
		return countryOriginRepository.save(countryOrgin);
	}

	@Override
	public void deleteCountryOrigin(long id) throws CountryOriginNotFound {
		countryOriginRepository.delete(id);
		
	}

	@Override
	public List<MCountryOrigin> findAllCountryOrigin() {
		return countryOriginRepository.findAll();
	}

	@Override
	public MCountryOrigin updateCountryOrigin(MCountryOrigin countryOrgin) throws CountryOriginNotFound {
		return countryOriginRepository.save(countryOrgin);
	}

	@Override
	public MCountryOrigin findByIdCountryOrigin(long id) {
		return countryOriginRepository.findOne(id);
	}

	@Override
	public MPack createPack(MPack pack) {		
		return packRepository.save(pack);
	}

	@Override
	public void deletePack(long id) throws CountryOriginNotFound {
		packRepository.delete(id);		
	}

	@Override
	public List<MPack> findAllPack() {		
		return packRepository.findAll();
	}

	@Override
	public MPack updatePack(MPack pack) throws CountryOriginNotFound {		
		return packRepository.save(pack);
	}

	@Override
	public MPack findByIdPack(long id) {		
		return packRepository.findOne(id);
	}

	@Override
	public MProduct createProduct(MProduct product) {		
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(long id) throws CountryOriginNotFound {
		productRepository.delete(id);		
	}

	@Override
	public List<MProduct> findAllProduct() {		
		return productRepository.findAll();
	}

	@Override
	public MProduct updateProduct(MProduct product) throws CountryOriginNotFound {		
		return productRepository.save(product);
	}

	@Override
	public MProduct findByIdProduct(long id) {
		
		return null;
	}

}
