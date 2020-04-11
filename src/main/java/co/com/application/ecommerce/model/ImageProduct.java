package co.com.application.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "imageProducts")
public class ImageProduct extends Image {
	
	private static final long serialVersionUID = -1884436150312557154L;

	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}