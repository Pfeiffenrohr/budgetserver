package de.lechner.cbudgetserver.rules;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface RuleRepository extends CrudRepository<Rule, Integer> {

    @Query(value= "select mode from rules where rule_id=:ruleId limit 1",nativeQuery = true)
    String findModeByRuleId(@Param("ruleId") Integer ruleId);
    
    @Query(value= "select command from rules where rule_id=:ruleId limit 1",nativeQuery = true)
    String findCommandByRuleId(@Param("ruleId") Integer ruleId);

}
