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
@PropertySource(encoding = "UTF-8", ignoreResourceNotFound = false, value = { "classpath:custom.properties" })
@ConfigurationProperties
@Validated
public class CustomProperties {

	@NotNull
	@Value("${path_img_category}")
	private String pathToCategoryImages;

	@NotNull
	@Value("${path_img_product}")
	private String pathToProductImages;

	@NotNull
	@Value("${decimal_for_usd}")
	private String decimalForUSD;

	@NotNull
	@Value("${decimal_for_cop}")
	private String decimalForCOP;

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

	public String getDecimalForUSD() {
		return decimalForUSD;
	}

	public void setDecimalForUSD(String decimalForUSD) {
		this.decimalForUSD = decimalForUSD;
	}

	public String getDecimalForCOP() {
		return decimalForCOP;
	}

	public void setDecimalForCOP(String decimalForCOP) {
		this.decimalForCOP = decimalForCOP;
	}
}
