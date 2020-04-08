package co.com.application.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.application.ecommerce.authorization.JWT;
import co.com.application.ecommerce.dto.AuthRequest;
import co.com.application.ecommerce.dto.AuthResponse;
import co.com.application.ecommerce.dto.CodeDTO;
import co.com.application.ecommerce.mail.EmailService;
import co.com.application.ecommerce.model.Code;
import co.com.application.ecommerce.model.User;
import co.com.application.ecommerce.service.ICodeService;
import co.com.application.ecommerce.service.IUserService;

@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	private IUserService userService;

	@Autowired
	private ICodeService codeService;
	
	@Autowired
	private EmailService emailService;


	@PostMapping(path = "/signin", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Code> signin(@RequestBody AuthRequest request) {

		User user = (User) userService.loadUserByUsername(request.getUser());
		if (userService.signin(request, user.getPassword())) {
			Code code = new Code();
			code.setIdUsuario(user.getId());
			code.setUsername(user.getUsername());
			code.setEndPoint("/auth/login");
			codeService.addCode(code);
			code.setCodeNumber(0);// limpiar codigo por seguridad.
			emailService.sendMessage(user.getEmail(),"Codigo de verificacion" , "Codigo de verficacion: " + code.getCodeNumber());
			return new ResponseEntity<>(code, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Code(), HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public ResponseEntity<AuthResponse> login(@RequestBody CodeDTO codeDto) {
		Code code = codeService.validateCode(codeDto);
		if(code != null) {
			String token = (new JWT()).initJWTToken(code.getUsername()).getToken();
			AuthResponse response = new AuthResponse();
			response.setUser(code.getUsername());
			response.setToken(token);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new AuthResponse(), HttpStatus.FORBIDDEN);
		}
	}
}
