package de.lechner.cbudgetserver.transaction;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>, JpaSpecificationExecutor<Transaction>{
	@Query(value= "select count(id) as anz,kategorie  from transaktionen where name like %:name% group by kategorie order by anz DESC limit 1",nativeQuery = true)
	String  findByName(@Param("name") String name);
	
	@Query(value= "select sum(wert) as summe from transaktionen where (datum >=:startdatum and datum <=:enddatum) and  kategorie=:categorie and konto_id=:konto",nativeQuery = true )
	String findSumMonthWithCategorie(@Param("startdatum") Date startdatum,@Param("enddatum") Date enddatum,@Param("categorie")  Integer categorie,@Param("konto") Integer konto);
	
	@Query(value= "select sum(wert) as summe from transaktionen where (datum >=:startdatum and datum <=:enddatum) and  name=:name and kategorie=:categorie and  konto_id=:konto",nativeQuery = true )
    String findSumMonthWithName(@Param("startdatum") Date startdatum,@Param("enddatum") Date enddatum,@Param("categorie")  Integer categorie,@Param("name") String name ,@Param("konto") Integer konto);
	
	@Query(value= "select sum(wert) as summe from transaktionen where (datum >=:startdatum and datum <=:enddatum) and konto_id=:konto",nativeQuery = true )
    String findSumMonth(@Param("startdatum") Date startdatum,@Param("enddatum") Date enddatum,@Param("konto") Integer konto);

	@Query(value= "select * from transaktionen where (datum >=:startdatum and datum <=:enddatum)" ,nativeQuery = true )
	//@Query(value= "select sum(wert) as w from transaktionen where (datum >=:startdatum and datum <=:enddatum);
	List <Transaction> findTransactionByDatum (@Param("startdatum") Date startdatum,@Param("enddatum") Date enddatum);
	
	List<Transaction> findByKategorie(Integer kategorie);
		     
}
