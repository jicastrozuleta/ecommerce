package co.com.application.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "imageCategories")
public class ImageCategory extends Image {

	private static final long serialVersionUID = 5797279287135281047L;

}
