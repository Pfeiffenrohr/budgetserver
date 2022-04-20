package de.lechner.cbudgetserver.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RuleController {
    
    @Autowired
    private RuleService ruleService;

    @RequestMapping("/rules/{ruleId}")
    public ResponseEntity<String> getkontobyName(@PathVariable("ruleId") Integer ruleId) {
        String id= ruleService.getModeByRuleId(ruleId);
        if ( id != null)
        {
        return new ResponseEntity<>(id, HttpStatus.OK);
        }
        else
        {
        return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }   
    }
    
}
