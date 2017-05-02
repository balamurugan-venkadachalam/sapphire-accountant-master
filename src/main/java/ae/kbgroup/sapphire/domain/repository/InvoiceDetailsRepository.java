package ae.kbgroup.sapphire.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ae.kbgroup.sapphire.domain.model.TInvoiceDetail;

public interface InvoiceDetailsRepository extends JpaRepository<TInvoiceDetail, Long>{

}
