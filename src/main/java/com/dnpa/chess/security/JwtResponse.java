package com.dnpa.chess.security;

import com.dnpa.chess.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
//@AllArgsConstructor
public class JwtResponse {
    private Integer id;
    private String accessToken;
    private String tokenType = "Bearer";
    private String username;
    private String name;
    private Role role;
    public JwtResponse(String jwt, int id, String username, String name, Role role) {
        this.accessToken = jwt;
        this.username = username;
        this.name = name;
        this.id = id;
        this.role = role;
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
    
}