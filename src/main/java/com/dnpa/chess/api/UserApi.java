package com.dnpa.chess.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnpa.chess.dto.SignUpDto;
import com.dnpa.chess.entity.User;
import com.dnpa.chess.exception.HttpResponse;
import com.dnpa.chess.mapper.UserMapper;
import com.dnpa.chess.repository.UserRepo;
import com.dnpa.chess.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/user")
public class UserApi {
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	@GetMapping("/all")
	public ResponseEntity<?> getAllUser(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable(name = "id") int id) {
		User user = userService.getUserById(id);
		if (user == null) {
			return ResponseEntity.badRequest().body(new HttpResponse("Không tìm thấy"));
		}
		return ResponseEntity.ok(user);
	}
	@PostMapping
	public ResponseEntity<?> addUser(@Valid @RequestBody SignUpDto signUpDto) {
		//TODO: process POST request
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
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable(name = "id") int id, @Valid @RequestBody SignUpDto signUpDto) {
		//TODO: process PUT request
		User user = userService.getUserById(id);
		
		if (user == null) {
			return ResponseEntity.badRequest().body(new HttpResponse("Không tìm thấy"));
		}
		user.setEmail( signUpDto.getEmail() );
        user.setGioiTinh( signUpDto.isGioiTinh() );
        user.setHoTen( signUpDto.getHoTen() );
        user.setPassword( signUpDto.getPassword() );
        user.setSoDienThoai( signUpDto.getSoDienThoai() );
        user.setUsername( signUpDto.getUsername() );
		
		return ResponseEntity.ok(user);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable(name = "id") int id) {
		User user = userService.getUserById(id);
		if (user == null) {
			return ResponseEntity.badRequest().body(new HttpResponse("Không tìm thấy"));
		}
		userService.deleteUser(id);
		return ResponseEntity.ok(user);
	}
}
