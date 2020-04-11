package co.com.application.ecommerce.service;

import co.com.application.ecommerce.model.Image;

public interface IImageService {

	public Image addImage(Image image);

	public void deleteImage(Image image);
	
	public Image findById(Long id);

}
