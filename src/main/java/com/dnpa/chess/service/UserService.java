package com.dnpa.chess.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnpa.chess.dto.ChangePasswordDto;
import com.dnpa.chess.entity.User;
import com.dnpa.chess.repository.UserRepo;
import com.dnpa.chess.security.JwtResponse;


public interface UserService {
	public User findUserByEmail(String email);
	public User findUserByUsername(String username);
	public JwtResponse loginAsUser(User user);
	public void logOutAsUser(HttpServletRequest request, HttpServletResponse response);
	public void saveUser(User user);
	public void addUser(User user);
	public User getUserById(int id);
	public List<User> getAllUsers();
	public void deleteUser(int id);
	public User getUserFromToken(String token);
	public User updateProfile(User user) throws Exception;
	User changePassword(String token, ChangePasswordDto changePasswordDto) throws Exception;
	List<User> getAllUsersNotAdmin();
}
