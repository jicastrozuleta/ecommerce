package co.com.application.ecommerce.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;

import org.springframework.validation.annotation.Validated;

import co.com.application.ecommerce.model.Category;

@Validated
public class CategoryDTO {

	@Null
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String description;

	private Category categoryFather;

	@NotEmpty
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

	public Category getCategoryFather() {
		return categoryFather;
	}

	public void setCategoryFather(Category categoryFather) {
		this.categoryFather = categoryFather;
	}

	public boolean isFather() {
		return isFather;
	}

	public void setIsFather(boolean isFather) {
		this.isFather = isFather;
	}
}
