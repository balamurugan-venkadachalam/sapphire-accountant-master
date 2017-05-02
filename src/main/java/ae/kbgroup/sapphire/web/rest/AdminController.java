package ae.kbgroup.sapphire.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ae.kbgroup.sapphire.domain.model.MCategory;
import ae.kbgroup.sapphire.domain.model.MCountryOrigin;
import ae.kbgroup.sapphire.domain.model.MPack;
import ae.kbgroup.sapphire.service.AdminService;

@RestController
@RequestMapping(value="admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/categories")
	public List<MCategory> getCategorys(){
		return adminService.findAllCategory();
	}
	
	@PostMapping("/category")
	public void saveCategory(@RequestBody MCategory category){
		adminService.createCategory(category);
	}
	
	@PutMapping("/category")
	public void updateCategory(@RequestBody MCategory category){
		adminService.updateCategory(category);
	}
	
	@GetMapping("/countryOrigins")
	public List<MCountryOrigin> getCountryOrgins(){
		return adminService.findAllCountryOrigin();
	}
	
	@PostMapping("/countryOrigin")
	public void saveCountryOrgin(@RequestBody MCountryOrigin countryOrigin){
		adminService.createCountryOrigin(countryOrigin);
	}
	
	@PutMapping("/countryOrigin")
	public void updateCountryOrigin(@RequestBody MCountryOrigin countryOrigin){
		adminService.updateCountryOrigin(countryOrigin);
	}
	
	@GetMapping("/packs")
	public List<MPack> getPacks(){
		return adminService.findAllPack();
	}
	
	@PostMapping("/pack")
	public void savePack(@RequestBody MPack pack){
		adminService.createPack(pack);
	}
	
	@PutMapping("/pack")
	public void updatePack(@RequestBody MPack pack){
		adminService.updatePack(pack);
	}
	
	

}
