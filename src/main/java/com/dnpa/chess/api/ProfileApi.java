package com.dnpa.chess.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnpa.chess.dto.ResponseObject;
import com.dnpa.chess.dto.SignUpDto;
import com.dnpa.chess.entity.User;
import com.dnpa.chess.exception.HttpResponse;
import com.dnpa.chess.mapper.UserMapper;
import com.dnpa.chess.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/profile")
@CrossOrigin
public class ProfileApi {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserService userService;
	@GetMapping
	public ResponseEntity<?> getUserFromToken(@RequestHeader("Authorization") String authorization){
		System.out.println(authorization);
		String token = authorization.substring(7); 
		return ResponseEntity.ok(userService.getUserFromToken(token));
		
	}
	@GetMapping
	public ResponseEntity<ResponseObject> getOverall()
	@PutMapping	
	public ResponseEntity<?> getUserFromToken(@RequestBody SignUpDto signUpDto){
		 
		try {
			return ResponseEntity.ok(userService.updateProfile(userMapper.map(signUpDto)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new HttpResponse(e.getMessage()));
		}
		
	}
	
	
}
