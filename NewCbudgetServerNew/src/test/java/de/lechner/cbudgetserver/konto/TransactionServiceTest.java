package de.lechner.cbudgetserver.konto;

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
class KontoServiceTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private KontoController Kontocontroller;
	
	@Mock
   private  KontoService Kontoservice;
	
	@Mock
	private KontoRepository KontoRepository;
	
	
	 
	
	@BeforeEach
	private void setUp() throws Exception {
		System.out.println("Setup");
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testKontoService() throws Exception {
		final  KontoController Kontocontroller = new KontoController();
		mockMvc = MockMvcBuilders.standaloneSetup(Kontocontroller).build();
		/*mockMvc.perform(
				MockMvcRequestBuilders.get("/hi")
				)
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("hi"));
		*/
		mockMvc.perform(
				MockMvcRequestBuilders.get("/Konto/2")
				)
		.andExpect(MockMvcResultMatchers.status().isOk());
		
		//when(Kontoservice.getKonto(Mockito.anyInt())).thenReturn(null);
	}

}
