package co.com.application.ecommerce.authorization;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JWT {

	private String token;

	public JWT initJWTToken(String user) {

		Date now = new Date();
		Calendar exp = Calendar.getInstance();
		exp.setTime(now);
		exp.add(Calendar.HOUR, Integer.parseInt(SecurityConf.EXPIRATION_HOURS.getConfigValue()));

		Key key = Keys.hmacShaKeyFor(SecurityConf.SECRET_KEY.getConfigValue().getBytes(StandardCharsets.UTF_8));
		token = SecurityConf.TOKEN_PREFIX.getConfigValue().concat(
				Jwts.builder()
				.setId(UUID.randomUUID().toString())
				.setSubject(user)
				.setIssuedAt(now)
				.setExpiration(exp.getTime())
				.signWith(key, SignatureAlgorithm.HS256)
				.compact());
		return this;
	}

	public String getToken() {
		return token;
	}
}
