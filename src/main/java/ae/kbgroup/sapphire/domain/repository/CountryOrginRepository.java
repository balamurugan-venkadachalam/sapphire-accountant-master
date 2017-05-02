package ae.kbgroup.sapphire.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ae.kbgroup.sapphire.domain.model.MCountryOrgin;

public interface CountryOrginRepository extends JpaRepository<MCountryOrgin, Long>{

}
