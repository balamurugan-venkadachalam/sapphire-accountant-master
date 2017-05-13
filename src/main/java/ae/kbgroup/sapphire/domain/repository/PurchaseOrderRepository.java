package ae.kbgroup.sapphire.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ae.kbgroup.sapphire.domain.model.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long>{

	List<PurchaseOrder> findPurchaseOrderByGrnCode(String grnCode);

}
