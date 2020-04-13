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

import co.com.application.ecommerce.Utils;
import co.com.application.ecommerce.dto.ProductDTO;
import co.com.application.ecommerce.model.Category;
import co.com.application.ecommerce.model.Product;
import co.com.application.ecommerce.properties.CustomProperties;
import co.com.application.ecommerce.service.ICategoryService;
import co.com.application.ecommerce.service.IProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private CustomProperties customProperties;

	@Autowired
	private ICategoryService categoryService;

	@PostMapping(path = "/product", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO) {
		if (productDTO == null || productDTO.getName().isBlank() || productDTO.getDescription().isBlank()
				|| productDTO.getPriceUSD().isBlank() || productDTO.getCategory() == null) {
			return new ResponseEntity<>(new Product(), HttpStatus.BAD_REQUEST);
		}
		Category category = categoryService.findById(productDTO.getCategory().getId());

		if (category == null)
			return new ResponseEntity<>(new Product(), HttpStatus.NOT_FOUND);
		
		if(category.isFather())
			return new ResponseEntity<>(new Product(), HttpStatus.BAD_REQUEST);

		Product product = new Product();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setCategory(category);
		product.setPriceUSD(
				Utils.generatePrice(productDTO.getPriceUSD(), Integer.parseInt(customProperties.getDecimalForUSD())));
		product = productService.addProduct(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping(path = "/product", produces = "application/json")
	public @ResponseBody ResponseEntity<List<Product>> getProducts() {
		return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
	}

	@DeleteMapping(path = "/product", produces = "application/json")
	public @ResponseBody ResponseEntity<ProductDTO> deleteCategory(@RequestBody ProductDTO productDTO) {
		if (productDTO == null || String.valueOf(productDTO.getId()).isBlank() || productDTO.getId() <= 0) {
			return new ResponseEntity<>(new ProductDTO(), HttpStatus.BAD_REQUEST);
		}
		Product product = productService.findById(productDTO.getId());
		if (product == null) {
			return new ResponseEntity<>(new ProductDTO(), HttpStatus.NOT_FOUND);
		}
		productService.deleteProduct(product);
		return new ResponseEntity<>(new ProductDTO(), HttpStatus.OK);
	}
}
