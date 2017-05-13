package ae.kbgroup.sapphire.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ae.kbgroup.sapphire.domain.model.InvoiceDetail;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long>{

}
