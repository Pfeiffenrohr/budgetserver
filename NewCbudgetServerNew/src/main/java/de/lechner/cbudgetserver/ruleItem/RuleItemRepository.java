package de.lechner.cbudgetserver.ruleItem;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface RuleItemRepository extends CrudRepository<RuleItem, Integer> { 
    @Query(value= "SELECT * FROM rules_item t WHERE rule_id = :ruleId ",nativeQuery = true)
    List<RuleItem>  findByRuleid(@Param("ruleId") Integer ruleId);

}
