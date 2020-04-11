package co.com.application.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.application.ecommerce.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
