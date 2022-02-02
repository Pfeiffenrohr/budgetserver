package de.lechner.cbudgetserver.rendite;


import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface RenditeRepository extends CrudRepository<Rendite, Integer> {
	
	@Query(value= "select * from rendite where datum =:datum and konto=:konto limit 1",nativeQuery = true )
    Rendite findByDateAndKonto(@Param("datum") Date datum,@Param("konto") Integer konto);
	}


