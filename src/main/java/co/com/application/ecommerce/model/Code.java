package co.com.application.ecommerce.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "codes")
public class Code implements Serializable {

	private static final long serialVersionUID = -5242718067048243939L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(nullable = false)
	private Long idUsuario;

	@NotEmpty
	@Column(nullable = false)
	private String username;

	@NotNull
	@Column(nullable = false)
	private Date expiration;

	@NotNull
	@Column(nullable = false)
	private int codeNumber;

	@NotEmpty
	@Column(nullable = false)
	private String endPoint;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public int getCodeNumber() {
		return codeNumber;
	}

	public void setCodeNumber(int code) {
		this.codeNumber = code;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
}
