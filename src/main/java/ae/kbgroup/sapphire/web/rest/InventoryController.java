package ae.kbgroup.sapphire.web.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ae.kbgroup.sapphire.domain.model.PurchaseOrder;
import ae.kbgroup.sapphire.service.InventoryService;

@RestController
@RequestMapping("invMgmt")
public class InventoryController {
	
	private Logger logger = Logger.getLogger(InventoryController.class);
	
	@Autowired
	private InventoryService inventoryService;
	
	
	@PostMapping("/importDetail")
	public void createImportDetail(@RequestBody PurchaseOrder importDetail){
		inventoryService.createImportDetail(importDetail);
	}
	
	@PutMapping("/importDetail")
	public void updateImportDetail(@RequestBody PurchaseOrder importDetail){
		inventoryService.updateImportDetail(importDetail);
	}
	
	@GetMapping("/importDetails")
	public List<PurchaseOrder> getImportDetails(){
		return inventoryService.findAllImportDetail();
	}
	
	@PostMapping("/search")
	public List<PurchaseOrder> getImportDetails(@RequestBody PurchaseOrder purchaseOrder ){
		logger.info(" getImportDetails "+ purchaseOrder.getGrnCode() );
		return inventoryService.findPurchaseOrderByGrnCode(purchaseOrder.getGrnCode());
	}
	

}
