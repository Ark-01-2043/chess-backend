package com.dnpa.chess.api;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dnpa.chess.dto.AlgorithmDTO;
import com.dnpa.chess.entity.Algorithm;
import com.dnpa.chess.entity.Level;
import com.dnpa.chess.exception.HttpResponse;
import com.dnpa.chess.service.AlgorithmService;
import com.dnpa.chess.service.LevelService;

@RestController
@RequestMapping("/api/algorithm")
@CrossOrigin
public class AlgorithmApi {
	@Autowired 
	private AlgorithmService algorithmService;
	@Autowired
	private LevelService levelService;
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(algorithmService.getAllAlgorithms());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getAlgorithm(@PathVariable(name = "id") int id){
		return ResponseEntity.ok(algorithmService.getAlgorithmById(id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
		Level level = levelService.getLevelByAlgorithm(id);
		if (level != null) {
			return ResponseEntity.badRequest().body(level);	
		}
		
		Algorithm algorithm = algorithmService.getAlgorithmById(id);
		deleteFromStatic(algorithm);
		algorithmService.deleteAlgorithm(id);
		return ResponseEntity.ok(algorithm);
	}
	@PostMapping
	public ResponseEntity<?> add(
			@RequestParam("name")String name, @RequestParam("file") MultipartFile multipartFile
			){
		
		if (multipartFile.isEmpty()) {
			return ResponseEntity.badRequest().body(new HttpResponse("Không để file trống"));
			
		}
		Algorithm algorithm = new Algorithm();
		algorithm.setName(name);	
		saveToStatic(multipartFile, multipartFile.getOriginalFilename());
		algorithm.setPath(multipartFile.getOriginalFilename());
		algorithmService.saveAlgorithm(algorithm);
		return ResponseEntity.ok(algorithm);
	}
	
	private void saveToStatic(MultipartFile multipartFile, String name) {
		Path savePath = Paths.get("src/main/resources/static/engine");
		if (!Files.exists(savePath)) {
			System.out.println("Path existed");
			try {
				Files.createDirectory(savePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot create path");
			}
		}
		try {
			InputStream inputStream = multipartFile.getInputStream();
			Path filePath = savePath.resolve(name);
	        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
	        System.out.println("luu thanh cong");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void deleteFromStatic(Algorithm algorithm) {
		Path savePath = Paths.get("src/main/resources/static/engine/" + algorithm.getPath());
		
		try {
			Files.delete(savePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cannot create path");
		}
		
		
	}
	
}
