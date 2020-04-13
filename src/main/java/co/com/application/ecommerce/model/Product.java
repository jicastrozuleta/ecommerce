package co.com.application.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = -2636900693337720411L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Column(nullable = false)
	private String name;

	@NotEmpty
	@Column(nullable = false)
	private String description;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<ImageProduct> images;

	@Column(nullable = false)
	private BigDecimal priceUSD;

	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Category category;

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

	public Set<ImageProduct> getImages() {
		return images;
	}

	public void setImages(Set<ImageProduct> images) {
		this.images = images;
	}

	public BigDecimal getPriceUSD() {
		return priceUSD;
	}

	public void setPriceUSD(BigDecimal priceUSD) {
		this.priceUSD = priceUSD;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
