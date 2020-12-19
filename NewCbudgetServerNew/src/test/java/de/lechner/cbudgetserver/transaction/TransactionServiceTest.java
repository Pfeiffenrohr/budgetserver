package de.lechner.cbudgetserver.transaction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class TransactionServiceTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private TransactionController transactioncontroller;
	
	@Mock
   private  TransactionService transactionservice;
	
	@Mock
	private TransactionRepository transactionRepository;
	
	
	 
	
	@BeforeEach
	private void setUp() throws Exception {
		System.out.println("Setup");
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testTransactionService() throws Exception {
		final  TransactionController transactioncontroller = new TransactionController();
		mockMvc = MockMvcBuilders.standaloneSetup(transactioncontroller).build();
		/*mockMvc.perform(
				MockMvcRequestBuilders.get("/hi")
				)
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("hi"));
		*/
		mockMvc.perform(
				MockMvcRequestBuilders.get("/transaction/255")
				)
		.andExpect(MockMvcResultMatchers.status().isOk());
		
		//when(transactionservice.getTransaction(Mockito.anyInt())).thenReturn(null);
	}

}
