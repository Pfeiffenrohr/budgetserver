package de.lechner.cbudgetserver.categorie;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Kategorien")
public class Categorie {
    
	@Id
	private Integer id;
	private String name;
	private String parent;
	private String description;
	private Double limit_month;
	private Double limit_year;
	private String mode;
	private Integer active;
	private Integer forecast;
	private Integer inflation;
	
	
	
	public Categorie(Integer id, String name, String parent, String description, Double limit_month, Double limit_year, String mode,
			Integer active, Integer forecast, Integer inflation) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.description = description;
		this.limit_month = limit_month;
		this.limit_year = limit_year;
		this.mode = mode;
		this.active = active;
		this.forecast = forecast;
		this.inflation = inflation;
	}
	


	public Categorie() {
		
	}
	
	
	
	public Integer getInflation() {
		return inflation;
	}



	public void setInflation(Integer inflation) {
		this.inflation = inflation;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getLimit_month() {
		return limit_month;
	}
	public void setLimit_month(Double limit_month) {
		this.limit_month = limit_month;
	}
	public Double getLimit_year() {
		return limit_year;
	}
	public void setLimit_year(Double limit_year) {
		this.limit_year = limit_year;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public Integer getForecast() {
		return forecast;
	}
	public void setForecast(Integer forecast) {
		this.forecast = forecast;
	}

	
}
