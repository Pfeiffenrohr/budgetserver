package de.lechner.cbudgetserver.bon;

	import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

	public interface BonRepository extends CrudRepository<Bon, Integer> {
		Bon findByrawnameMutant( String rawnameMutant);

	}
