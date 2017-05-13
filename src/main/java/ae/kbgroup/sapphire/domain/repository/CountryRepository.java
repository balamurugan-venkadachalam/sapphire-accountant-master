package ae.kbgroup.sapphire.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ae.kbgroup.sapphire.domain.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{

}
