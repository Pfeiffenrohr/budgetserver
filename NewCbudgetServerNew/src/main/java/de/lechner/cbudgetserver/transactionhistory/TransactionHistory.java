package de.lechner.cbudgetserver.transactionhistory;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaktion_history")
public class TransactionHistory {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	Integer trans_id;
	Integer type;
	Date datum;
	Date zeit;
	String curruser;
	
	public TransactionHistory() {
		
	}

	public TransactionHistory(Integer id, Integer trans_id, Integer type, Date datum, Date zeit, String curruser) {
		super();
		this.id = id;
		this.trans_id = trans_id;
		this.type = type;
		this.datum = datum;
		this.zeit = zeit;
		this.curruser = curruser;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(Integer trans_id) {
		this.trans_id = trans_id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		try {
			this.datum =  new SimpleDateFormat("yyyy-MM-dd").parse(datum);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
	}
	public Date getZeit() {
		return zeit;
	}
	public void setZeit(String zeit) {
		try {
			this.zeit =  new SimpleDateFormat("HH:mm:ss").parse(zeit);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
	}
	public String getCurruser() {
		return curruser;
	}
	public void setCurruser(String curruser) {
		this.curruser = curruser;
	}
	
}
