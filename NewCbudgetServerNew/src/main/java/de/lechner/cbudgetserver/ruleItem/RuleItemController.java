package de.lechner.cbudgetserver.ruleItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RuleItemController {

    @Autowired
    private RuleItemService ruleItemService;

    @RequestMapping("/ruleItem/{ruleId}")
    public List <RuleItem> getruleItem(@PathVariable("ruleId") String ruleId) {
       
        List <RuleItem> items = ruleItemService.getAllRullItemsPerRuleId(new Integer (ruleId));
        return items; 
    }
    
}
