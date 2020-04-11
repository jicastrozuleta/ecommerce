package co.com.application.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.application.ecommerce.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
