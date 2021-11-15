package de.lechner.cbudgetserver.kontomatch;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Kontomatch")

public class KontoMatch {
	@Id
	private Integer id;
	String depotname;
	String internalname;
	
	public KontoMatch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KontoMatch(Integer id, String depotname, String internalname) {
		super();
		this.id = id;
		this.depotname = depotname;
		this.internalname = internalname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepotname() {
		return depotname;
	}
	public void setDepotname(String depotname) {
		this.depotname = depotname;
	}
	public String getInternalname() {
		return internalname;
	}
	public void setInternalname(String internalname) {
		this.internalname = internalname;
	}
	
	

}
