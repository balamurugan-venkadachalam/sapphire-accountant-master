package ae.kbgroup.sapphire.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ae.kbgroup.sapphire.domain.model.MCountryOrigin;

public interface CountryOriginRepository extends JpaRepository<MCountryOrigin, Long>{

}
