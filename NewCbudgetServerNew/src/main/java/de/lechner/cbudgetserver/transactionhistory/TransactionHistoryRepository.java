package de.lechner.cbudgetserver.transactionhistory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import de.lechner.cbudgetserver.transaction.Transaction;


	public interface TransactionHistoryRepository extends CrudRepository<TransactionHistory, Integer> {
		
	}
