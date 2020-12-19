package de.lechner.cbudgetserver.transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaktionen")
public class Transaction {
	
	@Id
	Integer id;
	String name;
	Integer konto_id;
	Double wert;
	Date datum;
	String partner;
	String beschreibung;
	Integer kategorie;
	Integer kor_id;
	Integer cycle;
	String planed;

	public Transaction(Integer id, String name, Integer konto_id, Double wert, String datum, String partner,
			String beschreibung, Integer kategorie, Integer kor_id, Integer cycle, String planed) {
		super();
		this.id = id;
		this.name = name;
		this.konto_id = konto_id;
		this.wert = wert;
		try {
		this.datum =  new SimpleDateFormat("yyyy-MM-dd").parse(datum);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		this.partner = partner;
		this.beschreibung = beschreibung;
		this.kategorie = kategorie;
		this.kor_id = kor_id;
		this.cycle = cycle;
		this.planed = planed;
	}
	
	public Transaction()
	{
		
	}
	 
	public String writeTransactionToString()
	{
		return this.id+" "+this.name+" "+this.konto_id+" "+this.wert+
			   " "+this.datum+" "+this.partner+""+
			   this.beschreibung+" "+this.kategorie+" "+this.kor_id + 
			   " "+this.cycle+" "+this.planed;
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
	public Integer getKonto_id() {
		return konto_id;
	}
	public void setKonto_id(Integer konto_id) {
		this.konto_id = konto_id;
	}
	public Double getWert() {
		return wert;
	}
	public void setWert(Double wert) {
		this.wert = wert;
	}
	public String getDatum() {
		return   new SimpleDateFormat("yyyy-mm-dd").format(datum);
	}
	public void setDatum(String datum) {
		try {
			this.datum =  new SimpleDateFormat("yyyy-MM-dd").parse(datum);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public Integer getKategorie() {
		return kategorie;
	}
	public void setKategorie(Integer kategorie) {
		this.kategorie = kategorie;
	}
	public Integer getKor_id() {
		return kor_id;
	}
	public void setKor_id(Integer kor_id) {
		this.kor_id = kor_id;
	}
	public Integer getCycle() {
		return cycle;
	}
	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}
	public String getPlaned() {
		return planed;
	}
	public void setPlaned(String planed) {
		this.planed = planed;
	}


}
