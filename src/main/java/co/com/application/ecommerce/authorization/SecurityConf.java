package co.com.application.ecommerce.authorization;

public enum SecurityConf {

	EXPIRATION_HOURS("1"),
	TOKEN_PREFIX("Bearer "),
	TOKEN_HEADER("Authorization"),
	SECRET_KEY("fTK2PfTiC2020_VECTor_de_256_bits"); // debe ser de 32 caracteres o mas

	private String configValue;
	
	SecurityConf(String config) {
		this.configValue = config;
	}

	public String getConfigValue() {
		return configValue;
	}
}
