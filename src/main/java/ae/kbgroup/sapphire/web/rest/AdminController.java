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
import ae.kbgroup.sapphire.domain.model.MCountryOrgin;
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
	
	@GetMapping("/countryOrgines")
	public List<MCountryOrgin> getCountryOrgins(){
		return adminService.findAllCountryOrgin();
	}
	
	@PostMapping("/countryOrgin")
	public void saveCountryOrgin(@RequestBody MCountryOrgin countryOrgin){
		adminService.createCountryOrgin(countryOrgin);
	}
	
	@PutMapping("/countryOrgin")
	public void updateCountryOrgin(@RequestBody MCountryOrgin countryOrgin){
		adminService.updateCountryOrgin(countryOrgin);
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
