package co.com.application.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.application.ecommerce.model.Image;
import co.com.application.ecommerce.repository.ImageRepository;
import co.com.application.ecommerce.service.IImageService;

@Service
public class ImageServiceImpl implements IImageService {

	@Autowired
	private ImageRepository imageRepository;

	@Override
	public Image addImage(Image image) {
		return imageRepository.save(image);
	}

	@Override
	public void deleteImage(Image image) {
		imageRepository.delete(image);
	}

	@Override
	public Image findById(Long id) {
		return imageRepository.findById(id).orElse(null);
	}
}
