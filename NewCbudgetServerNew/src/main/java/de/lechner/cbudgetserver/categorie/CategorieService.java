package de.lechner.cbudgetserver.categorie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {
	
		
		@Autowired
		private CategorieRepository categorieRepository;

		List<Categorie> Categories = new ArrayList<Categorie>();
		
		public String greeting(String str) {
		return "Hi";
		}
				
		public List <Categorie> getAllCategories() {
			List<Categorie> t = new ArrayList<Categorie>();
			categorieRepository.findAll().forEach(t::add);
			return t;
			//return Categories;
		}
		
		public Categorie getCategorie(Integer id) {
			return  categorieRepository.findById((id)).orElse(new Categorie(255,"name2","parent","descripton",3000.0,3000.0,"m",1,1));
		}
		
		public void addCategorie(Categorie categorie)
		{
			categorieRepository.save(categorie);
		}
		public void updateCategorie(Categorie trans) {
			categorieRepository.save(trans);
		}
		public void deleteCategorie(int id) {
			categorieRepository.deleteById(id);
		}
		
	}
