package de.lechner.cbudgetserver.konto;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class KontoController {
		
		@Autowired
		private KontoService Kontoservice;
		
		 @GetMapping(value = "/hiKonto")
		public String sayHi() {
			return "hi";
		}
		
		  @GetMapping(value = "/kontos")
		public List <Konto> getAll() {
			  return Kontoservice.getAllKontos();
			
		  }	
		  
		 @RequestMapping("/konto/{id}") 
		 public Konto getKonto(@PathVariable("id") String id) {
			 if (Kontoservice==null) {
				 System.out.println("Kontoservice = null!!!!");
				 return (new Konto());		
			 }
				 Konto trans = Kontoservice.getKonto(new Integer(id));
			 return Kontoservice.getKonto(new Integer(id));
		}
		 
		 @RequestMapping(method=RequestMethod.POST, value="/kontos")
		 public void addKonto(@RequestBody Konto konto) {
			 Kontoservice.addKonto(konto);
		 }
		 
		 @RequestMapping(method=RequestMethod.PUT, value="/kontos")
		 public void updateKonto(@RequestBody Konto konto) {
			 Kontoservice.updateKonto(konto);
		 }
	    
		 @RequestMapping(method=RequestMethod.DELETE,value="/konto/{id}") 
		 public void deleteKonto(@PathVariable("id") String id) { 
			 Kontoservice.deleteKonto(new Integer(id));	
		 }
	}
