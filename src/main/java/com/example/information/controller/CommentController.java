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

import com.example.information.dto.CommentDTO;
import com.example.information.service.CommentService;





@RestController
@RequestMapping("/api/")
public class CommentController {

	CommentService commentservice;

	public CommentController(CommentService commentservice) {
		super();
		this.commentservice = commentservice;
	}
	@PostMapping("/infos/{infoId}/comments/")
	public ResponseEntity<CommentDTO> createComment(@PathVariable(value = "infoId") long infoId, @RequestBody CommentDTO commentDTO) {
		return new ResponseEntity<>(commentservice.createComment(infoId, commentDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/infos/{infoId}/comments/")
	public List<CommentDTO> getCommentsByPostId(@PathVariable(value = "infoId") Long infoId) {
		return commentservice.getCommentsByInfoId(infoId);
	}
	
	@GetMapping("/infos/{infoId}/comments/{id}/")
	public ResponseEntity<CommentDTO> getCommentById(@PathVariable(value = "infoId") Long infoId, @PathVariable(value = "id") long commentId){
		CommentDTO commentDTO = commentservice.getCommentById(infoId, commentId);
		return new ResponseEntity<>(commentDTO, HttpStatus.OK);
		}
	
	@PutMapping("/infos/{infoId}/comments/{id}/")
	public ResponseEntity<CommentDTO> updateComment(@PathVariable(value = "infoId") Long infoId, @PathVariable(value = "id") Long commentId, @RequestBody CommentDTO commentDTO){
		
		CommentDTO updatedComment = commentservice.updateComment(infoId, commentId, commentDTO);
		return new ResponseEntity<>(updatedComment, HttpStatus.OK);
		}
	

	@DeleteMapping("infos/{infoId}/comments/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable(value = "infoId") Long infoId, @PathVariable(value = "id") Long commentId) {
		commentservice.deletedComment(infoId, commentId);
		return new ResponseEntity<>("comment deleted successfully", HttpStatus.OK);
	}
}
