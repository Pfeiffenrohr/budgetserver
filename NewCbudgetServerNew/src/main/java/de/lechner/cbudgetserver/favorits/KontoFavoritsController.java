package de.lechner.cbudgetserver.favorits;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.lechner.cbudgetserver.konto.Konto;

@RestController
public class KontoFavoritsController {
	
	@Autowired
	private KontoFavoritsService kontoFavoritService;
	
	 @GetMapping(value = "/hiKontoFavorit")
	public String sayHi() {
		return "hi";
	}
	
	
	  
	 @RequestMapping("/kontoFavorit/{id}") 
	 public KontoFavorits getKonto(@PathVariable("id") String id) {
		 if (kontoFavoritService==null) {
			 System.out.println("kontoFavoritService = null!!!!");
			 return (new KontoFavorits());		
		 }
		 KontoFavorits trans = kontoFavoritService.getKontoFavorits(new Integer(id));
		 return kontoFavoritService.getKontoFavorits(new Integer(id));
	}
	 
	 
	  @GetMapping(value = "/kontoFavorits")
			public List <KontoFavorits> getAll() {
				  return kontoFavoritService.getAllKontoFavorits();
				
			  }	
	 
	 @RequestMapping(method=RequestMethod.POST, value="/kontoFavorit")
	 public void addKontoFavorit(@RequestBody KontoFavorits kontoFavorits) {
		 kontoFavoritService.addKontoFavorits(kontoFavorits);
	 }
	 
	 @RequestMapping(method=RequestMethod.PUT, value="/kontoFavorit")
	 public void updateKonto(@RequestBody KontoFavorits konto) {
		 kontoFavoritService.updateKontoFavorits(konto);
	 }
    
	 @RequestMapping(method=RequestMethod.DELETE,value="/kontoFavorit/{id}") 
	 public void deleteKonto(@PathVariable("id") String id) { 
		 kontoFavoritService.deleteKontoFavorits(new Integer(id));	
	 }
}
