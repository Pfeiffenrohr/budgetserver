package de.lechner.cbudgetserver.konto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;


public class SimpleKontoTest {

	 KontoService Kontoservice;
	
	 @BeforeEach
	void init()
	{
		 Kontoservice = new KontoService();
	}
	
	
 @AfterEach
 void docleanup() {
	 System.out.println("Cleanup");
 }
	
 @Test
 void testGreetingsFromKonto() {
	
	   String greeting = Kontoservice.greeting("Hi");
	   String expected ="Hi";
	   assertEquals(greeting,expected,"The Greetings in Konto does not work");
 }
	
}
