package de.lechner.cbudgetserver.transaction;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
	@Query(value= "select count(id) as anz,kategorie  from transaktionen where name like %:name% group by kategorie order by anz DESC limit 1",nativeQuery = true)
	String  findByName(@Param("name") String name);
	
	@Query(value= "select sum(wert) as summe from transaktionen where (datum >=:startdatum and datum <=:enddatum) and kategorie=:categorie",nativeQuery = true )
	String findSumMonth(@Param("startdatum") Date startdatum,@Param("enddatum") Date enddatum,@Param("categorie") Integer categorie);
	
	
	List<Transaction> findByKategorie(Integer kategorie);
}
