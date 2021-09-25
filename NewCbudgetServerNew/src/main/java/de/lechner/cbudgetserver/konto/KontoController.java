package de.lechner.cbudgetserver.konto;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class KontoController {
		
		@Autowired
		private KontoService kontoservice;
		
		 @GetMapping(value = "/hiKonto")
		public String sayHi() {
			return "hi";
		}
		
		  @GetMapping(value = "/kontos")
		public List <Konto> getAll() {
			  return kontoservice.getAllKontos();
			
		  }	
		  
		 @RequestMapping("/konto/{id}") 
		 public Konto getKonto(@PathVariable("id") String id) {
			 if (kontoservice==null) {
				 System.out.println("Kontoservice = null!!!!");
				 return (new Konto());		
			 }
				 Konto trans = kontoservice.getKonto(new Integer(id));
			 return kontoservice.getKonto(new Integer(id));
		}
		 /*
		 @RequestMapping("/kontoByName/{name}") 
		 public Integer getKontoByName(@PathVariable("name") String name) {
			 if (kontoservice==null) {
				 System.out.println("Kontoservice = null!!!!");
				 return (0);		
			 }
			 return kontoservice.getKontoByName(name);
		} 
		 */
		 
		 @RequestMapping("/kontoByName/{name}")
		 public ResponseEntity<Integer> getkontobyName(@PathVariable("name") String name) {
		     Integer id= kontoservice.getKontoByName(name);
		     if ( id != null)
		     {
		     return new ResponseEntity<>(id, HttpStatus.CREATED);
		     }
		     else
		     {
		     return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
	         }   
		 }
		 
		 
		 
		 @RequestMapping(method=RequestMethod.POST, value="/kontos")
		 public void addKonto(@RequestBody Konto konto) {
		     kontoservice.addKonto(konto);
		 }
		 
		 @RequestMapping(method=RequestMethod.PUT, value="/kontos")
		 public void updateKonto(@RequestBody Konto konto) {
		     kontoservice.updateKonto(konto);
		 }
	    
		 @RequestMapping(method=RequestMethod.DELETE,value="/konto/{id}") 
		 public void deleteKonto(@PathVariable("id") String id) { 
		     kontoservice.deleteKonto(new Integer(id));	
		 }
	}
