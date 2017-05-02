package ae.kbgroup.sapphire.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ae.kbgroup.sapphire.domain.model.TCustomerDetail;

public interface CustomerRepository extends JpaRepository<TCustomerDetail, Long>{

}
