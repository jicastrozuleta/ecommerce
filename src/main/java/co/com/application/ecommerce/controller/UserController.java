package co.com.application.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.application.ecommerce.dto.UserDTO;
import co.com.application.ecommerce.model.User;
import co.com.application.ecommerce.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
		if (userDTO == null || userDTO.getUsername().isBlank() || userDTO.getPassword().isBlank()) {
			return new ResponseEntity<>(new User(), HttpStatus.BAD_REQUEST);
		}
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		userService.addUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping(path = "/user", produces = "application/json")
	public @ResponseBody ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}
}
