package de.lechner.cbudgetserver.categorie;
import org.springframework.data.repository.CrudRepository;

import de.lechner.cbudgetserver.transaction.Transaction;

public interface CategorieRepository extends CrudRepository<Categorie, Integer> {

}
