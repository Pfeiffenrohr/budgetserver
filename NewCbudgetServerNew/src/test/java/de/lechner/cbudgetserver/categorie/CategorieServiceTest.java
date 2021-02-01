package de.lechner.cbudgetserver.categorie;


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
public class CategorieServiceTest {
	


	

		private MockMvc mockMvc;
		
		@InjectMocks
		private CategorieController Categoriecontroller;
		
		@Mock
	   private  CategorieService Categorieservice;
		
		@Mock
		private CategorieRepository CategorieRepository;
		
		
		 
		
		@BeforeEach
		private void setUp() throws Exception {
			System.out.println("Setup");
			MockitoAnnotations.initMocks(this);
		}
		
		@Test
		void testCategorieService() throws Exception {
			final  CategorieController Categoriecontroller = new CategorieController();
			mockMvc = MockMvcBuilders.standaloneSetup(Categoriecontroller).build();
			/*mockMvc.perform(
					MockMvcRequestBuilders.get("/hi")
					)
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("hi"));
			*/
			mockMvc.perform(
					MockMvcRequestBuilders.get("/categorie/25")
					)
			.andExpect(MockMvcResultMatchers.status().isOk());
			
			//when(Categorieservice.getCategorie(Mockito.anyInt())).thenReturn(null);
		}

	}


