package co.com.application.ecommerce.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import co.com.application.ecommerce.dto.AuthRequest;
import co.com.application.ecommerce.model.User;

public interface IUserService extends UserDetailsService {

	public boolean signin(AuthRequest requestSignin, String password);

	public User addUser(User user);
	public List<User> getUsers();
}
