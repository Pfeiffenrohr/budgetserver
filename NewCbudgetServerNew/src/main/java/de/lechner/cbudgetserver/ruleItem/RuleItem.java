package de.lechner.cbudgetserver.ruleItem;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rule_item")
public class RuleItem {
    
    @Id
    private Integer id;
    private Integer rule_id;
    private String art;
    private String operator;
    private String value;
    
    public RuleItem(Integer id, Integer rule_id, String art, String operator, String value) {
        super();
        this.id = id;
        this.rule_id = rule_id;
        this.art = art;
        this.operator = operator;
        this.value = value;
    }

     
    public RuleItem() {
        
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getRule_id() {
        return rule_id;
    }


    public void setRule_id(Integer rule_id) {
        this.rule_id = rule_id;
    }


    public String getArt() {
        return art;
    }


    public void setArt(String art) {
        this.art = art;
    }


    public String getOperator() {
        return operator;
    }


    public void setOperator(String operator) {
        this.operator = operator;
    }


    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }
    
    

}
