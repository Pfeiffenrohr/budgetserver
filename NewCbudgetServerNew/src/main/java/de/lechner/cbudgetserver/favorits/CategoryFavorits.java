package de.lechner.cbudgetserver.favorits;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categorie_favorits")
public class CategoryFavorits {
	@Id
	private Integer id;
	private Integer category;
	private Integer hits;	

}
