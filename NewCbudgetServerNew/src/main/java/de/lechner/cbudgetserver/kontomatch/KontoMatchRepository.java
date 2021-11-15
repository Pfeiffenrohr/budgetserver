package de.lechner.cbudgetserver.kontomatch;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface KontoMatchRepository  extends CrudRepository<KontoMatch, Integer> {
	
	@Query(value= "select internalname from kontomatch where depotname =:name limit 1",nativeQuery = true)
	String  findByName(@Param("name") String name);

}
