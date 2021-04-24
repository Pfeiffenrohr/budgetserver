package de.lechner.cbudgetserver.favorits;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface KontoFavoritsRepository extends CrudRepository<KontoFavorits, Integer> {
	
	
	@Query(value= "select *  from konto_favorits order by hits DESC",nativeQuery = true)
	List<KontoFavorits>  findKontoFavoritsSorted();

	}
