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
		
		  @GetMapping(value = "/Kontos")
		public List <Konto> getAll() {
			  return Kontoservice.getAllKontos();
			
		  }	
		  
		 @RequestMapping("/Konto/{id}") 
		 public Konto getKonto(@PathVariable("id") String id) {
			 if (Kontoservice==null) {
				 System.out.println("Kontoservice = null!!!!");
				 return (new Konto());		
			 }
				 Konto trans = Kontoservice.getKonto(new Integer(id));
			 if (Kontoservice==null)
			 {
				 System.out.println("Transaktion = null");
			 }
			 else
			 {
				 System.out.println("Transaktion = found");
			 } 
			 return Kontoservice.getKonto(new Integer(id));
		}
		 
		 @RequestMapping(method=RequestMethod.POST, value="/Kontos")
		 public void addKonto(@RequestBody Konto Konto) {
			 Kontoservice.addKonto(Konto);
		 }
		 
		 @RequestMapping(method=RequestMethod.PUT, value="/Kontos")
		 public void updateKonto(@RequestBody Konto Konto) {
			 Kontoservice.updateKonto(Konto);
		 }
	    
		 @RequestMapping(method=RequestMethod.DELETE,value="/Konto/{id}") 
		 public void deleteKonto(@PathVariable("id") String id) { 
			 Kontoservice.deleteKonto(new Integer(id));	
		 }
	}
