package co.com.application.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.application.ecommerce.model.Product;

public interface ProductRepositrory extends JpaRepository<Product, Long> {

}
