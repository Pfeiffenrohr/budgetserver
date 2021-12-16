package de.lechner.cbudgetserver.rendite;

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
	public class RenditeController {
		
		@Autowired
		private RenditeService renditeservice;
		
		 @GetMapping(value = "/hiRendite")
		public String sayHi() {
			return "hi";
		}
		
		  
		 @RequestMapping("/rendite/{id}") 
		 public Rendite getRendite(@PathVariable("id") String id) {
			 if (renditeservice==null) {
				 System.out.println("Renditeservice = null!!!!");
				 return (new Rendite());		
			 }
				 Rendite trans = renditeservice.getRendite(new Integer(id));
			 return renditeservice.getRendite(new Integer(id));
		}
		 	 
		 
		 @RequestMapping(method=RequestMethod.POST, value="/rendite")
		 public void addRendite(@RequestBody Rendite rendite) {
		     renditeservice.addRendite(rendite);
		 }
		 
		 @RequestMapping(method=RequestMethod.PUT, value="/rendite")
		 public void updateRendite(@RequestBody Rendite rendite) {
		     renditeservice.updateRendite(rendite);
		 }
	    
		 @RequestMapping(method=RequestMethod.DELETE,value="/rendite/{id}") 
		 public void deleteRendite(@PathVariable("id") String id) { 
		     renditeservice.deleteRendite(new Integer(id));	
		 }
	}
