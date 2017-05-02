package ae.kbgroup.sapphire.service;

import java.util.List;

import ae.kbgroup.sapphire.domain.model.MCategory;
import ae.kbgroup.sapphire.domain.model.MCountryOrgin;
import ae.kbgroup.sapphire.domain.model.MPack;
import ae.kbgroup.sapphire.domain.model.MProduct;
import ae.kbgroup.sapphire.exception.CategoryNotFound;
import ae.kbgroup.sapphire.exception.CountryOrginNotFound;

public interface AdminService {

	// Category
	public MCategory createCategory(MCategory category);

	public void deleteCategory(long id) throws CategoryNotFound;

	public List<MCategory> findAllCategory();

	public MCategory updateCategory(MCategory category) throws CategoryNotFound;

	public MCategory findByIdCategory(long id);
	
	
	// CountryOrgin
	public MCountryOrgin createCountryOrgin(MCountryOrgin countryOrgin);

	public void deleteCountryOrgin(long id) throws CountryOrginNotFound;

	public List<MCountryOrgin> findAllCountryOrgin();

	public MCountryOrgin updateCountryOrgin(MCountryOrgin countryOrgin) throws CountryOrginNotFound;

	public MCountryOrgin findByIdCountryOrgin(long id);
	
	
	// Pack
	public MPack createPack(MPack pack);

	public void deletePack(long id) throws CountryOrginNotFound;

	public List<MPack> findAllPack();

	public MPack updatePack(MPack pack) throws CountryOrginNotFound;

	public MPack findByIdPack(long id);
	

	// Product
	public MProduct createProduct(MProduct product);

	public void deleteProduct(long id) throws CountryOrginNotFound;

	public List<MProduct> findAllProduct();

	public MProduct updateProduct(MProduct product) throws CountryOrginNotFound;

	public MProduct findByIdProduct(long id);

}
