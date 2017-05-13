package ae.kbgroup.sapphire.service;

import java.util.List;

import ae.kbgroup.sapphire.domain.model.Category;
import ae.kbgroup.sapphire.domain.model.PurchaseOrder;
import ae.kbgroup.sapphire.exception.PurchaseOrderNotFoundException;

public interface InventoryService {
	
	// Category
	public PurchaseOrder createImportDetail(PurchaseOrder importDetail);

	public void deleteImportDetail(long id) throws PurchaseOrderNotFoundException;

	public List<PurchaseOrder> findAllImportDetail();

	public PurchaseOrder updateImportDetail(PurchaseOrder category) throws PurchaseOrderNotFoundException;

	public PurchaseOrder findByIdImportDetail(long id);

	public List<PurchaseOrder> findPurchaseOrderByGrnCode(String grnCode);

}
