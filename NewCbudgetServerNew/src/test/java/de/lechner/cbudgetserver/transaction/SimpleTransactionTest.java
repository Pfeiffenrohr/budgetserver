package de.lechner.cbudgetserver.transaction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;


public class SimpleTransactionTest {

	 TransactionService transactionservice;
	
	 @BeforeEach
	void init()
	{
		 transactionservice = new TransactionService();
	}
	
	
 @AfterEach
 void docleanup() {
	 System.out.println("Cleanup");
 }
	
 @Test
 void testGreetingsFromTransaction() {
	
	   String greeting = transactionservice.greeting("Hi");
	   String expected ="Hi";
	   assertEquals(greeting,expected,"The Greetings in Transaction does not work");
 }
	
}
