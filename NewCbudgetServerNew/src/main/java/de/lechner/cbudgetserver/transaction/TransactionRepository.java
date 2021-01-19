package de.lechner.cbudgetserver.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
	@Query(value= "select kategorie from transaktionen where name= :name group by kategorie order by kategorie limit 1",nativeQuery = true)
	String findByName(@Param("name") String name);
}
