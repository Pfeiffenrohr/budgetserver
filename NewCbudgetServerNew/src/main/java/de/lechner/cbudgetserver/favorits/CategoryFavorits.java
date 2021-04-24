package de.lechner.cbudgetserver.favorits;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category_favorits")
public class CategoryFavorits {
	@Id
	private Integer id;
	private Integer category;
	private Integer hits;
	
	public CategoryFavorits() {
		
	}
	
	public CategoryFavorits(Integer id, Integer category, Integer hits) {
		super();
		this.id = id;
		this.category = category;
		this.hits = hits;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}	

	
}
