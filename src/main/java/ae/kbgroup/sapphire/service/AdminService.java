package ae.kbgroup.sapphire.service;

import java.util.List;

import ae.kbgroup.sapphire.domain.model.Category;
import ae.kbgroup.sapphire.domain.model.Country;
import ae.kbgroup.sapphire.domain.model.Pack;
import ae.kbgroup.sapphire.domain.model.Product;
import ae.kbgroup.sapphire.domain.model.SupplierDetail;
import ae.kbgroup.sapphire.domain.model.CustomerDetail;
import ae.kbgroup.sapphire.exception.CategoryNotFoundException;
import ae.kbgroup.sapphire.exception.CountryOriginNotFoundException;
import ae.kbgroup.sapphire.exception.CustomerNotFoundException;

public interface AdminService {

	// Category
	public Category createCategory(Category category);

	public void deleteCategory(long id) throws CategoryNotFoundException;

	public List<Category> findAllCategory();

	public Category updateCategory(Category category) throws CategoryNotFoundException;

	public Category findByIdCategory(long id);
	
	
	// CountryOrgin
	public Country createCountryOrigin(Country country);

	public void deleteCountryOrigin(long id) throws CountryOriginNotFoundException;

	public List<Country> findAllCountryOrigin();

	public Country updateCountryOrigin(Country country) throws CountryOriginNotFoundException;

	public Country findByIdCountryOrigin(long id);
	
	
	// Pack
	public Pack createPack(Pack pack);

	public void deletePack(long id) throws CountryOriginNotFoundException;

	public List<Pack> findAllPack();

	public Pack updatePack(Pack pack) throws CountryOriginNotFoundException;

	public Pack findByIdPack(long id);
	

	// Product
	public Product createProduct(Product product);

	public void deleteProduct(long id) throws CountryOriginNotFoundException;

	public List<Product> findAllProduct();

	public Product updateProduct(Product product) throws CountryOriginNotFoundException;

	public Product findByIdProduct(long id);
	
	// Customer
	public CustomerDetail createCustomer(CustomerDetail customer);

	public void deleteCustomer(long id) throws CustomerNotFoundException;

	public List<CustomerDetail> findAllCustomer();

	public CustomerDetail updateCustomer(CustomerDetail customer) throws CustomerNotFoundException;

	public CustomerDetail findByIdCustomer(long id);
	
	

	public SupplierDetail createSupplier(SupplierDetail supplier) ;

	public void deleteSupplier(long id) throws CustomerNotFoundException ;

	public List<SupplierDetail> findAllSupplier();

	public SupplierDetail updateSupplier(SupplierDetail supplier) throws CustomerNotFoundException ;

	public SupplierDetail findByIdSupplier(long id) ;

}
