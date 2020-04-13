package co.com.application.ecommerce.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import co.com.application.ecommerce.model.Category;

public class ProductDTO {

	@Null
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String description;

	@NotNull
	private String priceUSD;

	@Null
	private String priceCOP;

	@NotNull
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

	public String getPriceUSD() {
		return priceUSD;
	}

	public void setPriceUSD(String priceUSD) {
		this.priceUSD = priceUSD;
	}

	public String getPriceCOP() {
		return priceCOP;
	}

	public void setPriceCOP(String priceCOP) {
		this.priceCOP = priceCOP;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
