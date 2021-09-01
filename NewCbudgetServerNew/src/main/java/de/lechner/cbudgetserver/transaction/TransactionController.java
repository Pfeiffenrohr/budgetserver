package de.lechner.cbudgetserver.transaction;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionservice;
	
	 @GetMapping(value = "/hi")
	public String sayHi() {
		return "hi";
	}
	
	  @GetMapping(value = "/transactions")
	public List <Transaction> getAll() {
		  return transactionservice.getAllTransactions();
		
	  }	
	  
	 @RequestMapping("/transaction/{id}") 
	 public Transaction getTransaction(@PathVariable("id") String id) {
		 if (transactionservice==null) {
			 System.err.println("transactionservice = null!!!!");
			 return (new Transaction(255,"name2",6,3.2,"2020-03-03","partner","beschrenbbui",26,31,1,"n"));		
		 }
			 Transaction trans = transactionservice.getTransaction(new Integer(id));
		
		 return transactionservice.getTransaction(new Integer(id));
	}
	 @RequestMapping("/transaction_by_kategorie/{kategorie}") 
	 public List<Transaction> getTransactionByKategorie(@PathVariable("kategorie") Integer kategorie) {
		 return transactionservice.getTransactionByKategorie(kategorie);
	} 
	 
	 @RequestMapping("/transaction_get_kategorie_byname/{name}") 
	 public String  getTransactionbyname(@PathVariable("name") String name) {
		 return transactionservice.getTransactionByName(name);
	}
	 
	 @RequestMapping("/transaction_get_sum")
	 @ResponseBody
	 public String getTransactrionSum(@RequestParam  Map<String,String> allParams) {
		 return  transactionservice.getTransactionSum(allParams);
	     //return "Parameters are " + allParams.entrySet();
	 }
	 
	 @RequestMapping(method=RequestMethod.POST, value="/transaction")
	 public void addTransaction(@RequestBody Transaction transaction) {
		 transactionservice.addTransaction(transaction);
	 }
	 
	 @RequestMapping(method=RequestMethod.PUT, value="/transaction")
	 public void updateTransaction(@RequestBody Transaction transaction) {
		 transactionservice.updateTransaction(transaction);
	 }
    
	 @RequestMapping(method=RequestMethod.DELETE,value="/transaction/{id}") 
	 public void deleteTransaction(@PathVariable("id") String id) { 
		 transactionservice.deleteTransaction(new Integer(id));	
	 }
}
