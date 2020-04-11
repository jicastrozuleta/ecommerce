package co.com.application.ecommerce.properties;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

@Configuration
@EnableConfigurationProperties
@PropertySource(encoding = "UTF-8", ignoreResourceNotFound = false, value = {"classpath:custom.properties"})
@ConfigurationProperties
@Validated
public class CustomProperties {

	@NotNull
	@Value("${path_img_category}")
	private String pathToCategoryImages;

	@NotNull
	@Value("${path_img_product}")
	private String pathToProductImages;

	public String getPathToCategoryImages() {
		return pathToCategoryImages;
	}

	public void setPathToCategoryImages(String pathToCategoryImages) {
		this.pathToCategoryImages = pathToCategoryImages;
	}

	public String getPathToProductImages() {
		return pathToProductImages;
	}

	public void setPathToProductImages(String pathToProductImages) {
		this.pathToProductImages = pathToProductImages;
	}
}
