package co.com.application.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.application.ecommerce.model.Category;
import co.com.application.ecommerce.repository.CategoryRepository;
import co.com.application.ecommerce.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.saveAndFlush(category);
	}

	@Override
	public void deleteCategory(Category category) {
		categoryRepository.delete(category);
	}

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
}
