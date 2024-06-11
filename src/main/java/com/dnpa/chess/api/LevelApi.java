package com.dnpa.chess.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dnpa.chess.dto.LevelDto;
import com.dnpa.chess.dto.ResponseObject;
import com.dnpa.chess.entity.Level;
import com.dnpa.chess.service.AlgorithmService;
import com.dnpa.chess.service.LevelService;

@RestController
@RequestMapping("/api/level")
@CrossOrigin
public class LevelApi {
	@Autowired
	private AlgorithmService algorithmService;
	@Autowired
	private LevelService levelService;
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(levelService.getAllLevels());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable(name = "id") int id){
		return ResponseEntity.ok(levelService.getLevelById(id));
	}
	@PostMapping
	public ResponseEntity<ResponseObject> addLevel(@RequestBody LevelDto levelDto){
		Level level = new Level();
		level.setAlgorithm(algorithmService.getAlgorithmById(levelDto.getAlgorithmId()));
		level.setDepth(levelDto.getDepth());
		level.setName(levelDto.getName());
		Level newLevel = levelService.saveLevel(level);
		return ResponseEntity.ok(new ResponseObject("Thêm thành công", HttpStatus.OK, newLevel));		
	}
	@PutMapping
	public ResponseEntity<?> put(@RequestBody LevelDto levelDto){
		Level level = new Level();
		level.setId(levelDto.getId());
		level.setDepth(levelDto.getDepth());
		level.setName(levelDto.getName());
		level.setAlgorithm(algorithmService.getAlgorithmById(levelDto.getId()));
		levelService.saveLevel(level);
		return ResponseEntity.ok(level);
	}
}
