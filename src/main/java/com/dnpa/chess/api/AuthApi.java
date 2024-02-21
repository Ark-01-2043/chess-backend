package com.dnpa.chess.api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dnpa.chess.dto.SignInDto;
import com.dnpa.chess.dto.SignUpDto;
import com.dnpa.chess.entity.User;
import com.dnpa.chess.exception.HttpResponse;
import com.dnpa.chess.mapper.UserMapper;
import com.dnpa.chess.repository.UserRepo;
import com.dnpa.chess.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
@Validated
public class AuthApi {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDto signUpDto){
		System.out.println("sign up");
//		System.out.println(authentication);
		if (userService.findUserByUsername(signUpDto.getUsername()) != null) {
			return ResponseEntity.badRequest().body(new HttpResponse("Tên đăng nhập đã tồn tại"));
		}
		if (userService.findUserByEmail(signUpDto.getEmail()) != null) {
			return ResponseEntity.badRequest().body(new HttpResponse("Email đã tồn tại"));
		}
		User user = userMapper.map(signUpDto);
		userService.addUser(user);
		return ResponseEntity.ok(userService.findUserByUsername(signUpDto.getUsername()));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> login(@Valid @RequestBody SignInDto signInDto, Authentication authentication){
		try {
			System.out.println("Sign in");
			Object object = SecurityContextHolder.getContext().getAuthentication().getDetails();
			if (object instanceof UserDetails) {
				UserDetails userDetails = (UserDetails) object;
				System.out.println(userDetails.getUsername());
			}
			if (authentication != null) {
				System.out.println("Signed in");
				return ResponseEntity.badRequest().body(new HttpResponse("Đã đăng nhập"));
			}
			return ResponseEntity.ok(userService.loginAsUser(userMapper.map(signInDto)));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
//			throw new ResourceException("Sai thông tin đăng nhập");
			return ResponseEntity.badRequest().body(new HttpResponse("Sai thông tin đăng nhập"));
		}
		
	}
	@GetMapping("/signout")
	public ResponseEntity<?> signOut(HttpServletRequest request, HttpServletResponse response){
		userService.logOutAsUser(request, response);
		return ResponseEntity.ok(new HttpResponse("Đăng xuất thành công")); 
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleValidationExceptions(
	  ConstraintViolationException ex) {
	    
	    System.out.println(ex.getConstraintViolations().toArray()[0]);
	    for (ConstraintViolation constraintViolation : ex.getConstraintViolations()) {
			System.out.println(constraintViolation.getMessage());
		}
	    System.out.println("method: " + ex.getMessage());
//	    throw new ResourceException(ex.getMessage());
	    return ResponseEntity.badRequest().body(new HttpResponse(ex.getMessage()));
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationExceptions(
		MethodArgumentNotValidException ex) {
	    System.out.println("method: " + ex.getAllErrors().get(0).getDefaultMessage());
//	    throw new ResourceException(ex.getAllErrors().get(0).getDefaultMessage());
	    return ResponseEntity.badRequest().body(new HttpResponse(ex.getAllErrors().get(0).getDefaultMessage()));
	}

	
}