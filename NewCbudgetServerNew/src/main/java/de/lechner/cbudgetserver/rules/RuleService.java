package de.lechner.cbudgetserver.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RuleService {
    
    @Autowired
    private RuleRepository ruleRepository;
    
    public String getModeByRuleId(Integer ruleId) {
        return  ruleRepository.findModeByRuleId(ruleId);
    }
    
    public String getCopmmandByRuleId(Integer ruleId) {
        return  ruleRepository.findCommandByRuleId(ruleId);
    }

}
