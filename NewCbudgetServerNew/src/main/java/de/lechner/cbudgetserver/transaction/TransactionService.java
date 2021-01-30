package de.lechner.cbudgetserver.transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.lechner.cbudgetserver.transactionhistory.TransactionHistory;
import de.lechner.cbudgetserver.transactionhistory.TransactionHistoryService;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TransactionHistoryService transactionHistoryService;
 
	List<Transaction> transactions = new ArrayList<Transaction>();
	
	public String greeting(String str) {
	return "Hi";
	}
			
	public List <Transaction> getAllTransactions() {
		List<Transaction> t = new ArrayList<Transaction>();
		transactionRepository.findAll().forEach(t::add);
		return t;
		//return transactions;
	}
	
	public Transaction getTransaction(Integer id) {
		return  transactionRepository.findById((id)).orElse(new Transaction(255,"nicht gefunden!!!!",6,3.2,"2020-03-03","partner","beschrenbbui",26,31,1,"n"));
	}
	
	public String  getTransactionByName(String name) {
		name= name.replace("%20" , " ").replace("%2C", ",").replace("%C3%A4", "ä");
		return  transactionRepository.findByName(name);  
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
	
}
