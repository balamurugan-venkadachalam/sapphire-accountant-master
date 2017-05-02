package ae.kbgroup.sapphire.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ae.kbgroup.sapphire.domain.model.TInvoice;

public interface InvoiceRepository extends JpaRepository<TInvoice, Long>{

}
