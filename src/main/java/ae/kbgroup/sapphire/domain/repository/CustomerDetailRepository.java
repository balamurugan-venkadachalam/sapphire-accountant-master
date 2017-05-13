package ae.kbgroup.sapphire.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ae.kbgroup.sapphire.domain.model.CustomerDetail;

public interface CustomerDetailRepository extends JpaRepository<CustomerDetail, Long>{

}
