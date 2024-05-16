package com.dnpa.chess.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnpa.chess.dto.ResponseObject;
import com.dnpa.chess.entity.Role;
import com.dnpa.chess.exception.HttpResponse;
import com.dnpa.chess.service.RoleService;
@RestController
@CrossOrigin
@RequestMapping("/api/role")
public class RoleApi {
	@Autowired
	private RoleService roleService;
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(roleService.getAll());
	}
	@PostMapping
	public ResponseEntity<?> add(@RequestBody Role role){
		roleService.addRole(role);
		return ResponseEntity.ok(ResponseObject.builder().message("Thêm thành công").build());
	}
}
