package de.lechner.cbudgetserver.favorits;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryFavoritsService {

	@Autowired
	private CategoryFavoritsRepository CategoryFavoritsRepository;

	List<CategoryFavorits> CategoryFavoritss = new ArrayList<CategoryFavorits>();
	
	public String greeting(String str) {
	return "Hi";
	}
			
	public List <CategoryFavorits> getAllCategoryFavorits() {
		//List<CategoryFavorits> t = new ArrayList<CategoryFavorits>();
		//CategoryFavoritsRepository.findAll().forEach(t::add);
		List<CategoryFavorits> t= CategoryFavoritsRepository.findCategoryFavoritsSorted();
		return t;
		//return CategoryFavoritss;
	}
	
	public CategoryFavorits getCategoryFavorits(Integer id) {
		return  CategoryFavoritsRepository.findById((id)).orElse(new CategoryFavorits(1,2,3));
	}
	
	public void addCategoryFavorits(CategoryFavorits CategoryFavorits)
	{
		CategoryFavoritsRepository.save(CategoryFavorits);
	}
	public void updateCategoryFavorits(CategoryFavorits trans) {
		CategoryFavoritsRepository.save(trans);
	}
	public void deleteCategoryFavorits(int id) {
		CategoryFavoritsRepository.deleteById(id);
	}
	
}

