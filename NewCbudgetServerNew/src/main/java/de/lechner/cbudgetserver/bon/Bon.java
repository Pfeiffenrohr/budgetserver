package de.lechner.cbudgetserver.bon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Bon")
//@GenericGenerator(name = "native", strategy = "native")
public class Bon {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 int id;
	String company;
	String rawname;
	String internalname;
	String rawnameMutant;
	Integer category;
	
	
	public Bon(int id, String company, String rawname, String internalname, String rawnameMutant, Integer category) {
		super();
		this.id = id;
		this.company = company;
		this.rawname = rawname;
		this.internalname = internalname;
		this.rawnameMutant = rawnameMutant;
		this.category = category;
	}
	
	public Bon() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRawname() {
		return rawname;
	}
	public void setRawname(String rawname) {
		this.rawname = rawname;
	}
	public String getInternalname() {
		return internalname;
	}
	public void setInternalname(String internalname) {
		this.internalname = internalname;
	}
	public String getRawnameMutant() {
		return rawnameMutant;
	}
	public void setRawnameMutant(String rawnameMutant) {
		this.rawnameMutant = rawnameMutant;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	

}
