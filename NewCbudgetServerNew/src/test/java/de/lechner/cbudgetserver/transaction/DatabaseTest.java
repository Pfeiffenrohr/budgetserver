package de.lechner.cbudgetserver.transaction;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@Disabled
@DataJpaTest
public class DatabaseTest {
	  @Autowired
	    private TestEntityManager entityManager;
	     
	    @Autowired
	    private TransactionRepository repository;
	     
	    @Test
	    public void testSaveNewProduct() {
	        entityManager.persist(new Transaction(null,"name3",6,3.2,"2020-03-03","partner","beschrenbbui",26,31,1,"n"));
	                 
	        Transaction transaction = repository.findById(2).orElseThrow();
	         
	        assertThat(transaction.getName()).isEqualTo("Waschpulver");
	    }

}
