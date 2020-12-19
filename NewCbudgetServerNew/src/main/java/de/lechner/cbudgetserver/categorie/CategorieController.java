package de.lechner.cbudgetserver.categorie;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class CategorieController {
		
		@Autowired
		private CategorieService Categorieservice;
		
		 @GetMapping(value = "/hiCategorie")
		public String sayHi() {
			return "hi";
		}
		
		  @GetMapping(value = "/categories")
		public List <Categorie> getAll() {
			  return Categorieservice.getAllCategories();
			
		  }	
		  
		 @RequestMapping("/categorie/{id}") 
		 public Categorie getCategorie(@PathVariable("id") String id) {
			 if (Categorieservice==null) {
				 System.out.println("Categorieservice = null!!!!");
				 return (new Categorie(255,"name2","parent","descripton",3000.0,3000.0,"m",1,1));		
			 }
				 Categorie trans = Categorieservice.getCategorie(new Integer(id));
			 if (Categorieservice==null)
			 {
				 System.out.println("Categorie = null");
			 }
			 else
			 {
				 System.out.println("Categorie = found");
			 } 
			 return Categorieservice.getCategorie(new Integer(id));
		}
		 
		 @RequestMapping(method=RequestMethod.POST, value="/categories")
		 public void addCategorie(@RequestBody Categorie Categorie) {
			 Categorieservice.addCategorie(Categorie);
		 }
		 
		 @RequestMapping(method=RequestMethod.PUT, value="/categories")
		 public void updateCategorie(@RequestBody Categorie Categorie) {
			 Categorieservice.updateCategorie(Categorie);
		 }
	    
		 @RequestMapping(method=RequestMethod.DELETE,value="/categorie/{id}") 
		 public void deleteCategorie(@PathVariable("id") String id) { 
			 Categorieservice.deleteCategorie(new Integer(id));	
		 }
	}
