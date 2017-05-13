package ae.kbgroup.sapphire.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ae.kbgroup.sapphire.domain.model.CustomerDetail;
import ae.kbgroup.sapphire.domain.model.SupplierDetail;

public interface SupplierDetailRepository extends JpaRepository<SupplierDetail, Long>{

}
