package de.lechner.cbudgetserver.konto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KontoRepository extends CrudRepository<Konto, Integer> {
	
	@Query(value= "select id from konten where kontoname =:name limit 1",nativeQuery = true)
	Integer  findByName(@Param("name") String name);

	@Query(value = "SELECT * FROM konten WHERE mode = :mode", nativeQuery = true)
	List<Konto> findByMode(@Param("mode") String mode);

	}


