package ae.kbgroup.sapphire.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ae.kbgroup.sapphire.domain.model.Category;
import ae.kbgroup.sapphire.domain.model.Country;
import ae.kbgroup.sapphire.domain.model.Pack;
import ae.kbgroup.sapphire.domain.model.Product;
import ae.kbgroup.sapphire.domain.model.SupplierDetail;
import ae.kbgroup.sapphire.domain.model.CustomerDetail;
import ae.kbgroup.sapphire.model.Customer;
import ae.kbgroup.sapphire.service.AdminService;

@RestController
@RequestMapping(value="admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/categories")
	public List<Category> getCategorys(){
		return adminService.findAllCategory();
	}
	
	@PostMapping("/category")
	public void saveCategory(@RequestBody Category category){
		adminService.createCategory(category);
	}
	
	@PutMapping("/category")
	public void updateCategory(@RequestBody Category category){
		adminService.updateCategory(category);
	}
	
	@GetMapping("/countryOrigins")
	public List<Country> getCountryOrgins(){
		return adminService.findAllCountryOrigin();
	}
	
	@PostMapping("/countryOrigin")
	public void saveCountryOrgin(@RequestBody Country countryOrigin){
		adminService.createCountryOrigin(countryOrigin);
	}
	
	@PutMapping("/countryOrigin")
	public void updateCountryOrigin(@RequestBody Country countryOrigin){
		adminService.updateCountryOrigin(countryOrigin);
	}
	
	@GetMapping("/packs")
	public List<Pack> getPacks(){
		return adminService.findAllPack();
	}
	
	@PostMapping("/pack")
	public void savePack(@RequestBody Pack pack){
		adminService.createPack(pack);
	}
	
	@PutMapping("/pack")
	public void updatePack(@RequestBody Pack pack){
		adminService.updatePack(pack);
	}
	
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return adminService.findAllProduct();
	}
	
	@PostMapping("/product")
	public void saveProduct(@RequestBody Product product){
		adminService.createProduct(product);
	}
	
	@PutMapping("/product")
	public void updateProduct(@RequestBody Product product){
		adminService.updateProduct(product);
	}
	
	
	
	@GetMapping("/customers")
	public List<CustomerDetail> getCustomers(){
		return adminService.findAllCustomer();
	}
	
	@PostMapping("/customer")
	public void saveCustomer(@RequestBody CustomerDetail customer){
		adminService.createCustomer(customer);
	}
	
	@PutMapping("/customer")
	public void updateCustomer(@RequestBody CustomerDetail customer){
		adminService.updateCustomer(customer);
	}
	
	@GetMapping("/suppliers")
	public List<SupplierDetail> getSuppliers(){
		return adminService.findAllSupplier();
	}
	
	@PostMapping("/supplier")
	public void saveSupplier(@RequestBody SupplierDetail customer){
		adminService.createSupplier(customer);
	}
	
	@PutMapping("/supplier")
	public void updateSupplier(@RequestBody SupplierDetail customer){
		adminService.updateSupplier(customer);
	}
	
	
	

}
