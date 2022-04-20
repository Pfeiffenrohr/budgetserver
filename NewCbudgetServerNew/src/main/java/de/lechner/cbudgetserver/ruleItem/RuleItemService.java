package de.lechner.cbudgetserver.ruleItem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RuleItemService {
    
    @Autowired
    private RuleItemRepository ruleItemRepository;

    
    public List <RuleItem> getAllRullItemsPerRuleId(Integer ruleId) {
        List<RuleItem> t = new ArrayList<RuleItem>();
       // ruleItemRepository.findAll().forEach(t::add);       
        t =  ruleItemRepository.findByRuleid(ruleId); 
        return t;
        //return Kontos;
    }
    
}
