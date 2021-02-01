package de.lechner.cbudgetserver.transactionhistory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionHistoryService {
	
	@Autowired
	private TransactionHistoryRepository TransactionHistoryRepository;

	List<TransactionHistory> TransactionHistorys = new ArrayList<TransactionHistory>();
	
	public String greeting(String str) {
	return "Hi";
	}
				
	public void addTransactionHistory(TransactionHistory TransactionHistory)
	{		
		TransactionHistoryRepository.save(TransactionHistory);
	}
	public void updateTransactionHistory(TransactionHistory trans) {
		TransactionHistoryRepository.save(trans);
	}
	public void deleteTransactionHistory(int id) {
		TransactionHistoryRepository.deleteById(id);
	}
	
}