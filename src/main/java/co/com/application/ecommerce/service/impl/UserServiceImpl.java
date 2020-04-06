package co.com.application.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.com.application.ecommerce.dto.AuthRequest;
import co.com.application.ecommerce.model.User;
import co.com.application.ecommerce.repository.UserRepository;
import co.com.application.ecommerce.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User loadUserByUsername(String username) {
		return this.userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Login Error, Username: " + username + " not found"));
	}

	@Override
	public boolean signin(AuthRequest requestSignin, String password) {
		return requestSignin.getPass().compareTo(password) == 0;
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}
}
