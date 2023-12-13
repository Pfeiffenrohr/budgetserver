package de.lechner.cbudgetserver.settings;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="settings")
public class Settings {
    @Id
    Integer id;
    String parameter;
    String wert;

    public Settings(Integer id, String parameter, String wert) {
        this.id = id;
        this.parameter = parameter;
        this.wert = wert;
    }

    public Settings() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getWert() {
        return wert;
    }

    public void setWert(String wert) {
        this.wert = wert;
    }
}
