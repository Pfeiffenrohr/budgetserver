package de.lechner.cbudgetserver.bon;
	
	
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class  BonController {
		
		@Autowired
		private BonService bonService;
		
		 @GetMapping(value = "/hiBon")
		public String sayHi() {
			return "hi";
		}
		
		  @GetMapping(value = "/bons")
		public List <Bon> getAll() {
			  return bonService.getAllBons();
			
		  }	
		  
		 @RequestMapping("/bon/{id}") 
		 public Bon getBon(@PathVariable("id") String id) {
			 if (bonService==null) {
				 System.out.println("bonService = null!!!!");
				 return (new Bon(1,"Netto","Käse","Käse","Edam2",2));		
			 }
				 Bon trans = bonService.getBon(new Integer(id));
			 if (bonService==null)
			 {
				 System.out.println("Bon = null");
			 }
			 else
			 {
				 System.out.println("Bon = found");
			 } 
			 return bonService.getBon(new Integer(id));
		}
		 
		 @RequestMapping(method=RequestMethod.POST, value="/bons")
		 public void addBon(@RequestBody Bon bon) {
			 bonService.addBon(bon);
		 }
		 
		 @RequestMapping(method=RequestMethod.PUT, value="/bons")
		 public void updateBon(@RequestBody Bon bon) {
			 bonService.updateBon(bon);
		 }
	    
		 @RequestMapping(method=RequestMethod.DELETE,value="/bon/{id}") 
		 public void deleteBon(@PathVariable("id") String id) { 
			 bonService.deleteBon(new Integer(id));	
		 }
	}

