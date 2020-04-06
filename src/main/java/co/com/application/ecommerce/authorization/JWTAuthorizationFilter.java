package co.com.application.ecommerce.authorization;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	public JWTAuthorizationFilter() {
		super();
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			if (existeJWTToken(request)) {
				Set<GrantedAuthority> grantedAuthorities = new HashSet<>();// por ahora no se le han asignado roles
				Authentication  auth = new UsernamePasswordAuthenticationToken(validateToken(request).getSubject(), "", grantedAuthorities);
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
			filterChain.doFilter(request, response);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			(response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
		}
	}

	private boolean existeJWTToken(HttpServletRequest request) {
		return request.getHeader(SecurityConf.TOKEN_HEADER.getConfigValue()) != null
				&& request.getHeader(SecurityConf.TOKEN_HEADER.getConfigValue())
						.startsWith(SecurityConf.TOKEN_PREFIX.getConfigValue());
	}

	private Claims validateToken(HttpServletRequest request){

		String jwtToken = request.getHeader(SecurityConf.TOKEN_HEADER.getConfigValue())
				.replace(SecurityConf.TOKEN_PREFIX.getConfigValue(), "");
		Key key = Keys.hmacShaKeyFor(SecurityConf.SECRET_KEY.getConfigValue().getBytes(StandardCharsets.UTF_8));
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtToken).getBody();
	}
}
