package de.lechner.cbudgetserver.orderrendite;

import de.lechner.cbudgetserver.kontomatch.KontoMatch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface OrderRenditeRepository extends CrudRepository<OrderRendite, Integer> {

}
