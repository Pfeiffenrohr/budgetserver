package de.lechner.cbudgetserver.transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import de.lechner.cbudgetserver.queryBuilder.BuildQueryForTransaction;
import de.lechner.cbudgetserver.transactionhistory.TransactionHistory;
import de.lechner.cbudgetserver.transactionhistory.TransactionHistoryService;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TransactionHistoryService transactionHistoryService;
	
	@Autowired
    private BuildQueryForTransaction queryBuilder;
 
	List<Transaction> transactions = new ArrayList<Transaction>();
	private String konto;
	private String startdatum;
	private String enddatum;
	
	public String greeting(String str) {
	return "Hi";
	}
			
	public List <Transaction> getAllTransactions() {
		List<Transaction> t = new ArrayList<Transaction>();
		transactionRepository.findAll().forEach(t::add);
		return t;
		//return transactions;
	}
	
	public List <Transaction> getAllErtrag() {
        List<Transaction> t = new ArrayList<Transaction>();
        t = transactionRepository.findAll(specErtrag);
        return t;
        //return transactions;
    }
	public Transaction getTransaction(Integer id) {
		return  transactionRepository.findById((id)).orElse(new Transaction(255,"nicht gefunden!!!!",6,3.2,"2020-03-03","partner","beschrenbbui",26,31,1,"n"));
	}
	
	public String  getTransactionByName(String name) {
		name= name.replace("%20" , " ").replace("%2C", ",").replace("%C3%A4", "ä").replace("%2F", "/").replace("%21", "!");
		return  transactionRepository.findByName(name);  
	}
	

	public String  getTransactionSum(Map<String,String> params) {
		String startdatum=params.get("startdate");
		String enddatum=params.get("enddate");
		String categorie = params.get("categorie");
		String konto = params.get("konto");
		String name = params.get("name");
		String ruleid = params.get("ruleid");
		try {
		    
		    if (name != null)
		    {
		        //System.out.println("select sum(wert) as summe from transaktionen where (datum >='" + startdatum+"' and datum <='"+enddatum+"') and  name='"+name+"' and kategorie= '"+categorie+"' and  konto_id= "+konto);
		        return transactionRepository.findSumMonthWithName(
	                    new SimpleDateFormat("yyyy-MM-dd").parse(startdatum),
	                    new SimpleDateFormat("yyyy-MM-dd").parse(enddatum),
	                    new Integer(categorie),
	                    new String(name),
	                    new Integer(konto));
	             
		    }
		    
		    if (categorie!=null)
	        {
	            
	        
			 return transactionRepository.findSumMonthWithCategorie(
					new SimpleDateFormat("yyyy-MM-dd").parse(startdatum),
					new SimpleDateFormat("yyyy-MM-dd").parse(enddatum),
					new Integer(categorie),
					new Integer(konto));
	        }
		    
		    if (ruleid != null)
            {
		        if (konto != null)
		            {
		             return queryBuilder.buildQuery(new Integer(ruleid),startdatum,enddatum,new Integer(konto));
		            }
		        else
		        {
		            return queryBuilder.buildQuery(new Integer(ruleid),startdatum,enddatum);
		        }
                /*return transactionRepository.findSumMonthWithName(
                        new SimpleDateFormat("yyyy-MM-dd").parse(startdatum),
                        new SimpleDateFormat("yyyy-MM-dd").parse(enddatum),
                        new Integer(categorie),
                        new String(name),
                        new Integer(konto));*/
                 
            }
		    else
		    {
	             return transactionRepository.findSumMonth(
	                     new SimpleDateFormat("yyyy-MM-dd").parse(startdatum),
	                     new SimpleDateFormat("yyyy-MM-dd").parse(enddatum),
	                     new Integer(konto));
		    }
		    
		} catch (Exception e)
		{
			e.printStackTrace();
			
		  return "falsche Paramater!";
		
		}
		
	}
	

	
	
	public List<Transaction> getTransactionByKategorie(Integer kategorie) {
		return  transactionRepository.findByKategorie(kategorie);  
	}
	
	
	public void addTransaction(Transaction transaction)
	{		
		 Date date = Calendar.getInstance().getTime(); 
		transactionRepository.save(transaction);
		//Insert TransactionHistory
		TransactionHistory transactionhistory = new TransactionHistory();
		transactionhistory.setTrans_id(transaction.getId());
		transactionhistory.setType(0);
		transactionhistory.setDatum(new SimpleDateFormat("yyyy-MM-dd").format(date));
		transactionhistory.setZeit(new SimpleDateFormat("HH:mm:ss").format(date));
		transactionhistory.setCurruser("budgetserver");
		
		transactionHistoryService.addTransactionHistory(transactionhistory);
		
	}
	public void updateTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
		 Date date = Calendar.getInstance().getTime(); 
			transactionRepository.save(transaction);
			//Insert TransactionHistory
			TransactionHistory transactionhistory = new TransactionHistory();
			transactionhistory.setTrans_id(transaction.getId());
			transactionhistory.setType(1);
			transactionhistory.setDatum(new SimpleDateFormat("yyyy-MM-dd").format(date));
			transactionhistory.setZeit(new SimpleDateFormat("HH:mm:ss").format(date));
			transactionhistory.setCurruser("budgetserver");
			
			transactionHistoryService.addTransactionHistory(transactionhistory);
	}
	public void deleteTransaction(int id) {
		transactionRepository.deleteById(id);
	}
	
	   
    Specification<Transaction> specErtrag = new Specification<Transaction>() {
        @Override
        public Predicate toPredicate(Root<Transaction> entity, CriteriaQuery<?> query, CriteriaBuilder cb) {                
            List<Predicate> conditions = ertragPredicate(cb, entity);
            return cb.and(conditions.toArray(new Predicate[conditions.size()]));
        }
        
        List<Predicate> ertragPredicate(CriteriaBuilder cb, Root<Transaction> entity) {
            List<Predicate> listPredicate = new ArrayList<Predicate>();
            Predicate ertrag = cb.equal(entity.get("name"), "Ertrag");
            listPredicate.add(ertrag);
            return listPredicate;
        }
    };
 
    
   
    
}

