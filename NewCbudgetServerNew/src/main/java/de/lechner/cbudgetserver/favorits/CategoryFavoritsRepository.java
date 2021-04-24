package de.lechner.cbudgetserver.favorits;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoryFavoritsRepository extends CrudRepository<CategoryFavorits, Integer>  {
	
	 @Query(value= "select *  from category_favorits order by hits DESC",nativeQuery = true)
	List<CategoryFavorits>  findCategoryFavoritsSorted();

	}

