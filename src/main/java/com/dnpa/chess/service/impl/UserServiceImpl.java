package com.dnpa.chess.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import com.dnpa.chess.dto.ChangePasswordDto;
import com.dnpa.chess.entity.User;
import com.dnpa.chess.repository.RoleRepository;
import com.dnpa.chess.repository.UserRepo;
import com.dnpa.chess.security.JwtResponse;
import com.dnpa.chess.security.JwtTokenProvider;
import com.dnpa.chess.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepo userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		try {
			return userRepository.findByUsername(username).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	@Override
	public JwtResponse loginAsUser(User user) {
		// TODO Auto-generated method stub
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);
        user = findUserByUsername(user.getUsername());
        return new JwtResponse(jwt, user.getId(), user.getUsername(), user.getHoTen(), user.getRole());
//		return new JwtResponse(user.getId(), jwt, "Beared ", user.getUsername(), user.getHoTen(), user.getRole());
	}
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
	}
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	@Override
	public List<User> getAllUsersNotAdmin(){
		return userRepository.findByRole(roleRepository.findById(1).get());
	}
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		user.setRole(roleRepository.findById(2).get());
		saveUser(user);
	}
	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		try {
			return userRepository.findByEmail(email).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	@Override
	public void logOutAsUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		System.out.println("authentication: " + authentication);
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
//			System.out.println("Dang xuat thanh cong");
		}
	}
	@Override
	public User getUserFromToken(String token) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(jwtTokenProvider.getUserNameFromJwtToken(token)).get(0);
	}
	@Override
	public User updateProfile(User user) throws Exception {
		// TODO Aut-generated method stub
		User oldUser = userRepository.findById(user.getId()).get();
		if (!oldUser.getEmail().equals(user.getEmail())) {
			List<User> newUser = userRepository.findByEmail(user.getEmail());
			if (newUser.size() > 0) {
				throw new Exception("Email đã tồn tại");
			}
		}
		oldUser.setEmail(user.getEmail());
		oldUser.setHoTen(user.getHoTen());
		oldUser.setSoDienThoai(user.getSoDienThoai());
		oldUser.setGioiTinh(user.isGioiTinh());
		return userRepository.save(oldUser);
		
	}
	@Override
	public User changePassword(String token, ChangePasswordDto changePasswordDto) throws Exception {
		
		String username = jwtTokenProvider.getUserNameFromJwtToken(token);
		User user = findUserByUsername(username);
		if (user == null) {
			throw new Exception("Token không hợp lệ");
		}
		if (!passwordEncoder.matches(user.getPassword(), username)) {
			throw new Exception("Mật khẩu không đúng");
		}
		user.setPassword(passwordEncoder.encode(changePasswordDto.getNewPassword()));
		return userRepository.save(user);
		
	}
}
