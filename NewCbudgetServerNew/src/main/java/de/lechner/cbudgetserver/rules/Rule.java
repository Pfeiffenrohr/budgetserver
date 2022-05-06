package de.lechner.cbudgetserver.rules;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="rules")
public class Rule {
    
    @Id
    private Integer id;
    private Integer rule_id;
    private String command;
    private String mode;
    
    
    public Rule(Integer id, Integer rule_id, String command, String mode) {
        super();
        this.id = id;
        this.rule_id = rule_id;
        this.command = command;
        this.mode = mode;
    }

    public Rule() {
        
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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
   
}
