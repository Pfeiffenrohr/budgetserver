package de.lechner.cbudgetserver.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
	@Query(value= "select count(id) as anz,kategorie  from transaktionen where name like %:name% group by kategorie order by anz DESC limit 1",nativeQuery = true)
	String  findByName(@Param("name") String name);
	List<Transaction> findByKategorie(Integer kategorie);
}
