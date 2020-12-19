package de.lechner.cbudgetserver.transaction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;

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
	
	public void addTransaction(Transaction transaction)
	{
		transactionRepository.save(transaction);
	}
	public void updateTransaction(Transaction trans) {
		transactionRepository.save(trans);
	}
	public void deleteTransaction(int id) {
		transactionRepository.deleteById(id);
	}
	
}
