package de.lechner.cbudgetserver.favorits;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryFavoritsController {

	@Autowired
	private CategoryFavoritsService categoryFavoritService;
	
	 @GetMapping(value = "/hicategoryFavorit")
	public String sayHi() {
		return "hi";
	}
	
	
	  
	 @RequestMapping("/categoryFavorit/{id}") 
	 public CategoryFavorits getcategory(@PathVariable("id") String id) {
		 if (categoryFavoritService==null) {
			 System.out.println("categoryFavoritService = null!!!!");
			 return (new CategoryFavorits());		
		 }
		 CategoryFavorits trans = categoryFavoritService.getCategoryFavorits(new Integer(id));
		 return categoryFavoritService.getCategoryFavorits(new Integer(id));
	}
	 
	 
	  @GetMapping(value = "/categoryFavorits")
			public List <CategoryFavorits> getAll() {
				  return categoryFavoritService.getAllCategoryFavorits();
				
			  }	
	 
	 @RequestMapping(method=RequestMethod.POST, value="/categoryFavorit")
	 public void addcategoryFavorit(@RequestBody CategoryFavorits categoryFavorits) {
		 categoryFavoritService.addCategoryFavorits(categoryFavorits);
	 }
	 
	 @RequestMapping(method=RequestMethod.PUT, value="/categoryFavorit")
	 public void updatecategory(@RequestBody CategoryFavorits category) {
		 categoryFavoritService.updateCategoryFavorits(category);
	 }
    
	 @RequestMapping(method=RequestMethod.DELETE,value="/categoryFavorit/{id}") 
	 public void deletecategory(@PathVariable("id") String id) { 
		 categoryFavoritService.deleteCategoryFavorits(new Integer(id));	
	 }
}
