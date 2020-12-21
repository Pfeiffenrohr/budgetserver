package de.lechner.cbudgetserver.konto;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class DatabaseTest {
	  @Autowired
	    private TestEntityManager entityManager;
	     
	    @Autowired
	    private KontoRepository repository;
	     
	    @Test
	    public void testSaveNewProduct() {
	        entityManager.persist(new Konto(255,"name3","y",4000.0,2000.0,"desc","mode"));
	                 
	        Konto Konto = repository.findById(255).orElseThrow();
	         
	        assertThat(Konto.getKontoname()).isEqualTo("name3");
	    }

}
