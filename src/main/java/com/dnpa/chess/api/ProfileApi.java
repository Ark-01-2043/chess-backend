package com.dnpa.chess.api;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnpa.chess.dto.ChangePasswordDto;
import com.dnpa.chess.dto.ResponseObject;
import com.dnpa.chess.dto.SignUpDto;
import com.dnpa.chess.entity.User;
import com.dnpa.chess.exception.HttpResponse;
//import com.dnpa.chess.mapper.UserMapper;
import com.dnpa.chess.service.GameService;
import com.dnpa.chess.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/profile")
@CrossOrigin
public class ProfileApi {
//	@Autowired
//	private UserMapper userMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private GameService gameService;
	@GetMapping
	public ResponseEntity<?> getUserFromToken(@RequestHeader("Authorization") String authorization){
		System.out.println(authorization);
		String token = authorization.substring(7); 
		return ResponseEntity.ok(userService.getUserFromToken(token));
		
	}
	@GetMapping("/overall")
	public ResponseEntity<ResponseObject> getOverall(@RequestHeader("Authorization") String authString){
		String token = authString.substring(7);
		return ResponseEntity.ok(new ResponseObject("", HttpStatus.OK,gameService.getOverallDetails(token)));
	}
	@GetMapping("/history")
	public ResponseEntity<ResponseObject> getHistory(@RequestHeader("Authorization") String authString){
		String token = authString.substring(7);
		return ResponseEntity.ok(new ResponseObject("Lấy lịch sử", HttpStatus.OK, gameService.getHistory(token)));
	}
	@GetMapping("/history/{id}")
	public ResponseEntity<ResponseObject> getHistoryById(@PathVariable("id") int id){
		
		return ResponseEntity.ok(new ResponseObject("Lấy lịch sử",HttpStatus.OK,gameService.getHistoryByUserUd(id)));
	}
	@PutMapping	
	public ResponseEntity<?> updateProfile(@RequestBody SignUpDto signUpDto){
		 
		try {
			User user = new User();
			user.setId(signUpDto.getId());
			user.setHoTen(signUpDto.getHoTen());
			user.setUsername(signUpDto.getUsername());
			user.setEmail(signUpDto.getEmail());
			user.setGioiTinh(signUpDto.isGioiTinh());
			user.setPassword(signUpDto.getPassword());
			user.setSoDienThoai(signUpDto.getSoDienThoai());
			return ResponseEntity.ok(userService.updateProfile(user));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ResponseObject(e.getMessage(), HttpStatus.BAD_REQUEST, null));
		}
		
	}
	@PutMapping("/changePassword")
	public ResponseEntity<ResponseObject> changePassword(@RequestHeader("Authorization") String authString, @Valid @RequestBody ChangePasswordDto changePasswordDto) throws Exception{
		String token = authString.substring(7);
		return ResponseEntity.ok(new ResponseObject("",HttpStatus.OK,userService.changePassword(token, changePasswordDto)));
	}
	
}
