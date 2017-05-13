package ae.kbgroup.sapphire.service.impl;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ae.kbgroup.sapphire.domain.model.Category;
import ae.kbgroup.sapphire.domain.model.Country;
import ae.kbgroup.sapphire.domain.model.Pack;
import ae.kbgroup.sapphire.domain.model.Product;
import ae.kbgroup.sapphire.domain.model.SupplierDetail;
import ae.kbgroup.sapphire.domain.model.CustomerDetail;
import ae.kbgroup.sapphire.domain.repository.CategoryRepository;
import ae.kbgroup.sapphire.domain.repository.CountryRepository;
import ae.kbgroup.sapphire.domain.repository.CustomerDetailRepository;
import ae.kbgroup.sapphire.domain.repository.PackRepository;
import ae.kbgroup.sapphire.domain.repository.ProductRepository;
import ae.kbgroup.sapphire.domain.repository.SupplierDetailRepository;
import ae.kbgroup.sapphire.exception.CategoryNotFoundException;
import ae.kbgroup.sapphire.exception.CountryOriginNotFoundException;
import ae.kbgroup.sapphire.exception.CustomerNotFoundException;
import ae.kbgroup.sapphire.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CountryRepository countryOriginRepository;
	
	@Autowired
	private PackRepository packRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerDetailRepository customerRepository;
	
	@Autowired
	private SupplierDetailRepository supplierDetailRepository;
	
	@Transactional
	@Override
	public Category createCategory(Category category) {
		category.setCreatedDate(new Date(System.currentTimeMillis()));
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(long id) throws CategoryNotFoundException {
		categoryRepository.delete(id);
	}

	@Override
	public List<Category> findAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public Category updateCategory(Category category) throws CategoryNotFoundException {
		category.setCreatedDate(new Date(System.currentTimeMillis()));
		return categoryRepository.save(category);
	}

	@Override
	public Category findByIdCategory(long id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public Country createCountryOrigin(Country country) {
		country.setCreatedDate(new Date(System.currentTimeMillis()));
		return countryOriginRepository.save(country);
	}

	@Override
	public void deleteCountryOrigin(long id) throws CountryOriginNotFoundException {
		countryOriginRepository.delete(id);
		
	}

	@Override
	public List<Country> findAllCountryOrigin() {
		return countryOriginRepository.findAll();
	}

	@Override
	public Country updateCountryOrigin(Country country) throws CountryOriginNotFoundException {
		country.setCreatedDate(new Date(System.currentTimeMillis()));
		return countryOriginRepository.save(country);
	}

	@Override
	public Country findByIdCountryOrigin(long id) {
		return countryOriginRepository.findOne(id);
	}

	@Override
	public Pack createPack(Pack pack) {	
		pack.setCreatedDate(new Date(System.currentTimeMillis()));
		return packRepository.save(pack);
	}

	@Override
	public void deletePack(long id) throws CountryOriginNotFoundException {
		packRepository.delete(id);		
	}

	@Override
	public List<Pack> findAllPack() {		
		return packRepository.findAll();
	}

	@Override
	public Pack updatePack(Pack pack) throws CountryOriginNotFoundException {	
		pack.setCreatedDate(new Date(System.currentTimeMillis()));
		return packRepository.save(pack);
	}

	@Override
	public Pack findByIdPack(long id) {		
		return packRepository.findOne(id);
	}

	@Override
	public Product createProduct(Product product) {	
		product.setCreatedDate(new Date(System.currentTimeMillis()));
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(long id) throws CountryOriginNotFoundException {
		productRepository.delete(id);		
	}

	@Override
	public List<Product> findAllProduct() {		
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Product product) throws CountryOriginNotFoundException {		
		product.setCreatedDate(new Date(System.currentTimeMillis()));
		return productRepository.save(product);
	}

	@Override
	public Product findByIdProduct(long id) {
		
		return productRepository.findOne(id);
	}

	@Override
	public SupplierDetail createSupplier(SupplierDetail supplier) {
	
		return supplierDetailRepository.save(supplier);
	}

	@Override
	public void deleteSupplier(long id) throws CustomerNotFoundException {
		supplierDetailRepository.delete(id);
		
	}

	@Override
	public List<SupplierDetail> findAllSupplier() {
		return supplierDetailRepository.findAll();
	}

	@Override
	public SupplierDetail updateSupplier(SupplierDetail supplier) throws CustomerNotFoundException {
		return supplierDetailRepository.save(supplier);
	}

	@Override
	public SupplierDetail findByIdSupplier(long id) {

		return supplierDetailRepository.findOne(id);
	}

	
	
	@Override
	public CustomerDetail createCustomer(CustomerDetail customer) {
	
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(long id) throws CustomerNotFoundException {
		customerRepository.delete(id);
		
	}

	@Override
	public List<CustomerDetail> findAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public CustomerDetail updateCustomer(CustomerDetail customer) throws CustomerNotFoundException {
		return customerRepository.save(customer);
	}

	@Override
	public CustomerDetail findByIdCustomer(long id) {

		return customerRepository.findOne(id);
	}

}
