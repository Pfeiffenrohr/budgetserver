package de.lechner.cbudgetserver.renditebatch;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface RenditeBatchRepository extends CrudRepository<RenditeBatch, Integer> {

}

