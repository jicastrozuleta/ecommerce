package co.com.application.ecommerce.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
public class Category implements Serializable {

	private static final long serialVersionUID = -5085761347797322130L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Column(nullable = false)
	private String name;

	@NotEmpty
	@Column(nullable = false)
	private String description;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Image image;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Product> products;

	@ManyToOne
	@JoinColumn(name = "idCategoryFather")
	private Category categoryFather;

	@OneToMany(mappedBy = "categoryFather", cascade = CascadeType.REMOVE)
	private List<Category> categorySon;

	@Column(nullable = false)
	private boolean isFather;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Category getCategoryFather() {
		return categoryFather;
	}

	public void setCategoryFather(Category categoryFather) {
		this.categoryFather = categoryFather;
	}

	@JsonIgnore
	public List<Category> getCategorySon() {
		return categorySon;
	}

	public void setCategorySon(List<Category> categorySon) {
		this.categorySon = categorySon;
	}

	public boolean isFather() {
		return isFather;
	}

	public void setFather(boolean isFather) {
		this.isFather = isFather;
	}
}
