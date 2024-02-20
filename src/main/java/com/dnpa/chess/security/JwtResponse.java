package com.dnpa.chess.security;

import com.dnpa.chess.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private Integer id;
    private String accessToken;
    private String tokenType = "Bearer";
    private String username;
    private String name;
    private Role role;
//    public JwtResponse(String jwt, int id, String username, String name, Role role) {
//        this.accessToken = jwt;
//        this.username = username;
//        this.name = name;
//        this.id = id;
//        this.role = role;
//    }
}