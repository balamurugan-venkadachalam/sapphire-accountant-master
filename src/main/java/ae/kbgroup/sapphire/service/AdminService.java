package ae.kbgroup.sapphire.service;

import java.util.List;

import ae.kbgroup.sapphire.domain.model.MCategory;
import ae.kbgroup.sapphire.domain.model.MCountryOrigin;
import ae.kbgroup.sapphire.domain.model.MPack;
import ae.kbgroup.sapphire.domain.model.MProduct;
import ae.kbgroup.sapphire.exception.CategoryNotFound;
import ae.kbgroup.sapphire.exception.CountryOriginNotFound;

public interface AdminService {

	// Category
	public MCategory createCategory(MCategory category);

	public void deleteCategory(long id) throws CategoryNotFound;

	public List<MCategory> findAllCategory();

	public MCategory updateCategory(MCategory category) throws CategoryNotFound;

	public MCategory findByIdCategory(long id);
	
	
	// CountryOrgin
	public MCountryOrigin createCountryOrigin(MCountryOrigin countryOrgin);

	public void deleteCountryOrigin(long id) throws CountryOriginNotFound;

	public List<MCountryOrigin> findAllCountryOrigin();

	public MCountryOrigin updateCountryOrigin(MCountryOrigin countryOrgin) throws CountryOriginNotFound;

	public MCountryOrigin findByIdCountryOrigin(long id);
	
	
	// Pack
	public MPack createPack(MPack pack);

	public void deletePack(long id) throws CountryOriginNotFound;

	public List<MPack> findAllPack();

	public MPack updatePack(MPack pack) throws CountryOriginNotFound;

	public MPack findByIdPack(long id);
	

	// Product
	public MProduct createProduct(MProduct product);

	public void deleteProduct(long id) throws CountryOriginNotFound;

	public List<MProduct> findAllProduct();

	public MProduct updateProduct(MProduct product) throws CountryOriginNotFound;

	public MProduct findByIdProduct(long id);

}
