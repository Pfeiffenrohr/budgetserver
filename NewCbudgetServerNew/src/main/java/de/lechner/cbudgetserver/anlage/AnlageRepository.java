package de.lechner.cbudgetserver.anlage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AnlageRepository extends CrudRepository<Anlage, Integer> {
    
    }