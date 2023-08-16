package com.example.information.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.information.dto.InfoDTO;
import com.example.information.service.InfoService;

@RestController
@RequestMapping("/api/infos/")
public class InfoController {

	private InfoService infoService;
	
	
	
	public InfoController(InfoService infoService) {
		super();
		this.infoService = infoService;
	}

	@PostMapping
	public ResponseEntity<InfoDTO> createInfo(@RequestBody InfoDTO infoDTO) {
		return new ResponseEntity<>(infoService.createPost(infoDTO), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<InfoDTO> getAllInfo() {
		return infoService.getAllInfo();
	}
	@GetMapping("/{id}/")
	public ResponseEntity<InfoDTO> getInfoById(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(infoService.getInfoById(id));
	}
	@PutMapping("/{id}/")
	public ResponseEntity<InfoDTO> updatePost(@RequestBody InfoDTO infoDTO, @PathVariable(name = "id") long id) {
		InfoDTO infoResponse = infoService.updatedInfo(infoDTO, id);
		return new ResponseEntity<>(infoResponse, HttpStatus.OK);
	}
	@DeleteMapping
	public ResponseEntity<String> deleteInfo(@PathVariable(name = "id")long id) {
		return new ResponseEntity<>("Info was deleted.", HttpStatus.OK);
	}
}
