package com.dnpa.chess.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.dnpa.chess.mapper.UserMapper;
import com.dnpa.chess.service.GameService;
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
		return ResponseEntity.ok(ResponseObject.builder().data(gameService.getOverallDetails(token))
												.message("")
												.status(HttpStatus.OK).build());
	}
	@GetMapping("/history")
	public ResponseEntity<ResponseObject> getHistory(@RequestHeader("Authorization") String authString){
		String token = authString.substring(7);
		return ResponseEntity.ok(ResponseObject.builder().data(gameService.getHistory(token))
														.message("Lấy lịch sử")
														.status(HttpStatus.OK).build());
	}
	@PutMapping	
	public ResponseEntity<?> updateProfile(@RequestBody SignUpDto signUpDto){
		 
		try {
			return ResponseEntity.ok(userService.updateProfile(userMapper.map(signUpDto)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().body(ResponseObject.builder().message(e.getMessage()).build());
		}
		
	}
	@PutMapping("/changePassword")
	public ResponseEntity<ResponseObject> changePassword(@RequestHeader("Authorization") String authString, @Valid @RequestBody ChangePasswordDto changePasswordDto) throws Exception{
		String token = authString.substring(7);
		return ResponseEntity.ok(ResponseObject.builder().data(userService.changePassword(token, changePasswordDto)).build());
	}
	
}
