package co.com.application.ecommerce.service;

import java.util.List;

import co.com.application.ecommerce.model.Product;

public interface IProductService {

	public Product addProduct(Product product);

	public void deleteProduct(Product roduct);
	
	public List<Product> getAll();
	
	public Product findById(Long id);

}
