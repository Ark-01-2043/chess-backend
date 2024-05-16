package com.dnpa.chess.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dnpa.chess.dto.GameDto;
import com.dnpa.chess.dto.ResponseObject;
import com.dnpa.chess.entity.Game;
import com.dnpa.chess.exception.HttpResponse;
import com.dnpa.chess.service.GameService;




@RestController
@CrossOrigin
@RequestMapping("/api/game")
public class GameApi {
	@Autowired
	private GameService gameService;
	
	@PostMapping
	public ResponseEntity<?> saveGame(@RequestBody GameDto gameDto) {
		
		return ResponseEntity.ok(gameService.saveGame(gameDto));
	}
	@GetMapping("/{id}")
	private ResponseEntity<?> getUserGame(@PathVariable(name = "id") int id){
		return ResponseEntity.ok(gameService.getAllGameOfUser(id));
	}
	@GetMapping
	private ResponseEntity<?> get(){
		return ResponseEntity.ok(gameService.getAllGames());
	}
	@PostMapping("/ai")
	public ResponseEntity<?> makeMove1(@RequestBody GameDto gameDto){
		try {
			
	        return ResponseEntity.ok(ResponseObject.builder().data(gameService.generateNextMove(gameDto))
	        												.message("Nước đi kế tiếp")
	        												.status(HttpStatus.OK).build());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new HttpResponse("Vui lòng tải lại file"));
			
		}
        
	}
	@GetMapping("/ranking")
	public ResponseEntity<?> getRanking(){
		return ResponseEntity.ok(gameService.getRanking());
	}
	public static void main(String[] args) {
		System.out.println(LocalDateTime.parse("2023-10-19T18:25:13"));
	}
}