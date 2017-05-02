package ae.kbgroup.sapphire.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ae.kbgroup.sapphire.domain.model.MCategory;
import ae.kbgroup.sapphire.domain.model.MCountryOrgin;
import ae.kbgroup.sapphire.domain.model.MPack;
import ae.kbgroup.sapphire.domain.model.MProduct;
import ae.kbgroup.sapphire.domain.repository.CategoryRepository;
import ae.kbgroup.sapphire.domain.repository.CountryOrginRepository;
import ae.kbgroup.sapphire.domain.repository.PackRepository;
import ae.kbgroup.sapphire.domain.repository.ProductRepository;
import ae.kbgroup.sapphire.exception.CategoryNotFound;
import ae.kbgroup.sapphire.exception.CountryOrginNotFound;
import ae.kbgroup.sapphire.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CountryOrginRepository countryOrginRepository;
	
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
	public MCountryOrgin createCountryOrgin(MCountryOrgin countryOrgin) {
		return countryOrginRepository.save(countryOrgin);
	}

	@Override
	public void deleteCountryOrgin(long id) throws CountryOrginNotFound {
		countryOrginRepository.delete(id);
		
	}

	@Override
	public List<MCountryOrgin> findAllCountryOrgin() {
		return countryOrginRepository.findAll();
	}

	@Override
	public MCountryOrgin updateCountryOrgin(MCountryOrgin countryOrgin) throws CountryOrginNotFound {
		return countryOrginRepository.save(countryOrgin);
	}

	@Override
	public MCountryOrgin findByIdCountryOrgin(long id) {
		return countryOrginRepository.findOne(id);
	}

	@Override
	public MPack createPack(MPack pack) {		
		return packRepository.save(pack);
	}

	@Override
	public void deletePack(long id) throws CountryOrginNotFound {
		packRepository.delete(id);		
	}

	@Override
	public List<MPack> findAllPack() {		
		return packRepository.findAll();
	}

	@Override
	public MPack updatePack(MPack pack) throws CountryOrginNotFound {		
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
	public void deleteProduct(long id) throws CountryOrginNotFound {
		productRepository.delete(id);		
	}

	@Override
	public List<MProduct> findAllProduct() {		
		return productRepository.findAll();
	}

	@Override
	public MProduct updateProduct(MProduct product) throws CountryOrginNotFound {		
		return productRepository.save(product);
	}

	@Override
	public MProduct findByIdProduct(long id) {
		
		return null;
	}

}
