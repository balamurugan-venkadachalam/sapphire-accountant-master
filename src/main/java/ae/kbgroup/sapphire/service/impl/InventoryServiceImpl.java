package ae.kbgroup.sapphire.service.impl;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ae.kbgroup.sapphire.domain.model.Category;
import ae.kbgroup.sapphire.domain.model.Country;
import ae.kbgroup.sapphire.domain.model.Pack;
import ae.kbgroup.sapphire.domain.model.Product;
import ae.kbgroup.sapphire.domain.model.PurchaseOrder;
import ae.kbgroup.sapphire.domain.model.SupplierDetail;
import ae.kbgroup.sapphire.domain.repository.CategoryRepository;
import ae.kbgroup.sapphire.domain.repository.CountryRepository;
import ae.kbgroup.sapphire.domain.repository.PurchaseOrderRepository;
import ae.kbgroup.sapphire.domain.repository.SupplierDetailRepository;
import ae.kbgroup.sapphire.domain.repository.PackRepository;
import ae.kbgroup.sapphire.domain.repository.ProductRepository;
import ae.kbgroup.sapphire.exception.CategoryNotFoundException;
import ae.kbgroup.sapphire.exception.CountryOriginNotFoundException;
import ae.kbgroup.sapphire.exception.PurchaseOrderNotFoundException;
import ae.kbgroup.sapphire.exception.PackNotFoundException;
import ae.kbgroup.sapphire.exception.ProductNotFoundException;
import ae.kbgroup.sapphire.exception.PurchaseOrderException;
import ae.kbgroup.sapphire.exception.SupplierNotFoundException;
import ae.kbgroup.sapphire.service.InventoryService;
import ae.kbgroup.sapphire.util.NumberUtil;

@Service
public class InventoryServiceImpl implements InventoryService{
	

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CountryRepository countryOriginRepository;
	
	@Autowired
	private PackRepository packRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@Autowired
	private SupplierDetailRepository supplierDetailRepository;
	

	@Override
	public PurchaseOrder createImportDetail(PurchaseOrder importDetail) {
		
		validateData(importDetail);
		importDetail.setCreatedDate(new Date(System.currentTimeMillis()));		
		purchaseOrderRepository.save(importDetail);

		return importDetail;
	}


	@Override
	public void deleteImportDetail(long id) throws PurchaseOrderNotFoundException {
		purchaseOrderRepository.delete(id);
		
	}

	@Override
	public List<PurchaseOrder> findAllImportDetail() {
		return purchaseOrderRepository.findAll();
	}

	@Override
	public PurchaseOrder updateImportDetail(PurchaseOrder importDetail) throws PurchaseOrderNotFoundException {
		validateData(importDetail);
		importDetail.setUpdatedDate(new Date(System.currentTimeMillis()));
		return purchaseOrderRepository.save(importDetail);
	}

	@Override
	public PurchaseOrder findByIdImportDetail(long id) {
		
		return purchaseOrderRepository.findOne(id);
	}
	
	@Override
	public List<PurchaseOrder> findPurchaseOrderByGrnCode(String grnCode) {

		return purchaseOrderRepository.findPurchaseOrderByGrnCode(grnCode);
	}
	
	

	private void validateData(PurchaseOrder purchaseOrder) {
		 List<PurchaseOrder> purchaseOrders =purchaseOrderRepository.findPurchaseOrderByGrnCode(purchaseOrder.getGrnCode().trim());
		 
		 if(!purchaseOrders.isEmpty()){
			 throw new PurchaseOrderException("GRN number already available");
			 
		 } else if (!NumberUtil.isValidNumber(purchaseOrder.getCategory().getId())){
			 throw new CategoryNotFoundException("Category is not found in input");
			 
		 } else if (!NumberUtil.isValidNumber(purchaseOrder.getCountry().getId())){
			 throw new CountryOriginNotFoundException("Country is not found in input");
			 
		 } else if (!NumberUtil.isValidNumber(purchaseOrder.getPack().getId())){
			 throw new PackNotFoundException("Pack is not found in input");
			 
		 } else if (!NumberUtil.isValidNumber(purchaseOrder.getProduct().getId())){
				throw new ProductNotFoundException("Product is not found in input");
			 
		 } else if (!NumberUtil.isValidNumber(purchaseOrder.getSupplier().getId())){
				throw new SupplierNotFoundException("Supplier is not found in input");
		 }		

	}
	
	
	private void validateLookUp(PurchaseOrder purchaseOrder){
		
		if(null != purchaseOrder.getCategory() && purchaseOrder.getCategory().getId() > 0){
			Category category = categoryRepository.findOne(purchaseOrder.getCategory().getId());
			if(null == category){
				throw new CategoryNotFoundException("Category is not found in system");
			}
			purchaseOrder.setCategory(category);
			
		}else if (null != purchaseOrder.getCountry() && purchaseOrder.getCountry().getId() > 0){
			Country countryOrigini =  countryOriginRepository.findOne(purchaseOrder.getCountry().getId());
			if(null == countryOrigini){
				throw new CountryOriginNotFoundException("Country is not found in system");
			}
			purchaseOrder.setCountry(countryOrigini);
			
		}else if (null != purchaseOrder.getPack() && purchaseOrder.getPack().getId() > 0){
			Pack pack = packRepository.findOne(purchaseOrder.getPack().getId());
			if(null == pack){
				throw new PackNotFoundException("Pack is not found in system");
			}
			purchaseOrder.setPack(pack);
			
		}else if (null != purchaseOrder.getProduct() && purchaseOrder.getProduct().getId() > 0){
			Product product = productRepository.findOne(purchaseOrder.getProduct().getId());
			if(null == product){
				throw new ProductNotFoundException("Product is not found in system");
			}
			purchaseOrder.setProduct(product);
		}else if (null != purchaseOrder.getSupplier() && purchaseOrder.getSupplier().getId() > 0){
			SupplierDetail supplier = supplierDetailRepository.findOne(purchaseOrder.getSupplier().getId());
			if(null == supplier){
				throw new SupplierNotFoundException("Supplier is not found in system");
			}
			purchaseOrder.setSupplier(supplier);
		}
	}

}
