package co.com.application.ecommerce.service;

import java.util.List;

import co.com.application.ecommerce.model.Category;

public interface ICategoryService {

	public Category addCategory(Category category);

	public void deleteCategory(Category category);
	
	public List<Category> getAll();
	
	public Category findById(Long id);
}
