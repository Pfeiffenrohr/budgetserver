package de.lechner.cbudgetserver.transaction;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
	@Query(value= "select count(id) as anz,kategorie  from transaktionen where name like %:name% group by kategorie order by anz DESC limit 1",nativeQuery = true)
	String  findByName(@Param("name") String name);
	
	@Query(value= "select sum(wert) as summe from transaktionen where (datum >=:startdatum and datum <=:enddatum) and  kategorie=:categorie and konto_id=:konto",nativeQuery = true )
	String findSumMonthWithCategorie(@Param("startdatum") Date startdatum,@Param("enddatum") Date enddatum,@Param("categorie")  Integer categorie,@Param("konto") Integer konto);
	
	@Query(value= "select sum(wert) as summe from transaktionen where (datum >=:startdatum and datum <=:enddatum) and konto_id=:konto",nativeQuery = true )
    String findSumMonth(@Param("startdatum") Date startdatum,@Param("enddatum") Date enddatum,@Param("konto") Integer konto);
	
	
	List<Transaction> findByKategorie(Integer kategorie);
}
