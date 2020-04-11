package co.com.application.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.application.ecommerce.dto.CategoryDTO;
import co.com.application.ecommerce.model.Category;
import co.com.application.ecommerce.service.ICategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@PostMapping(path = "/category", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Category> addCategory(@RequestBody CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setName(categoryDTO.getName());
		category.setDescription(categoryDTO.getDescription());
		category.setFather(categoryDTO.isFather());
		if (categoryDTO.getCategoryFather() != null && !String.valueOf(categoryDTO.getCategoryFather().getId()).isBlank() && categoryDTO.getCategoryFather().getId() > 0) {
			Category categoryFather = categoryService.findById(categoryDTO.getCategoryFather().getId());
			category.setCategoryFather(categoryFather);
		}
		return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);
	}

	@GetMapping(path = "/category", produces = "application/json")
	public @ResponseBody ResponseEntity<List<Category>> getCategories() {
		return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/category", produces = "application/json")
	public @ResponseBody ResponseEntity<CategoryDTO> deleteCategory(@RequestBody CategoryDTO categoryDTO) {
		if(categoryDTO == null || String.valueOf(categoryDTO.getId()).isBlank() || categoryDTO.getId() <= 0) {
			return new ResponseEntity<>(new CategoryDTO(), HttpStatus.BAD_REQUEST);
		}
		Category category = categoryService.findById(categoryDTO.getId());
		if(category == null) {
			return new ResponseEntity<>(new CategoryDTO(), HttpStatus.NOT_FOUND);
		}
		categoryService.deleteCategory(category);
		return new ResponseEntity<>(new CategoryDTO(), HttpStatus.OK);
	}
}
