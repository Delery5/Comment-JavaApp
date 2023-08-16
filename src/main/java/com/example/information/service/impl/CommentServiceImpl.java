package com.example.information.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.information.dto.CommentDTO;
import com.example.information.entity.Comment;
import com.example.information.entity.Info;
import com.example.information.exception.ResourceNotFoundException;
import com.example.information.repository.CommentRepository;
import com.example.information.repository.InfoRepository;
import com.example.information.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	private CommentRepository commentrepository;
	private InfoRepository inforepository;
	public CommentServiceImpl(CommentRepository commentrepository, InfoRepository inforepository) {
		super();
		this.commentrepository = commentrepository;
		this.inforepository = inforepository;
	}
	
	@Override
	public CommentDTO createComment(long infoId, CommentDTO commentDTO) {

		Comment comment = mapToEntity(commentDTO);
		
		//retrieve post by id
		Info info = inforepository.findById(infoId).orElseThrow(() -> new ResourceNotFoundException("Info", "id", infoId));
		
		//set info to comment entity
		comment.setInfo(info);
		
		//comment entity to DB
		Comment newComment = commentrepository.save(comment);
		
		return mapToDTO(newComment);
	}

	private CommentDTO mapToDTO(Comment comment) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setId(comment.getId());
		commentDTO.setName(comment.getName());
		commentDTO.setComment(comment.getComment());
		return commentDTO;
	}
	
	private Comment mapToEntity(CommentDTO commentDTO) {
		Comment comment = new Comment();
		comment.setId(commentDTO.getId());
		comment.setName(commentDTO.getName());
		comment.setComment(commentDTO.getComment());
		return comment;
	}

	@Override
	public List<CommentDTO> getCommentsByInfoId(long infoId) {
		//retrieve info entity by id
		List<Comment> comments = commentrepository.findByInfoId(infoId);
				
		//convert list of comment entities to list of comment dto's
		return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
		
	}

	@Override
	public CommentDTO getCommentById(Long infoId, Long commentId) {
		//retrieve post entity by id
		Info info = inforepository.findById(infoId).orElseThrow(() -> new ResourceNotFoundException("Info", "id", infoId));
		
		
		//retrieve comments by postId
		Comment comment = commentrepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "id", commentId));
		comment.setInfo(info);

	
		return mapToDTO(comment);
	}

	@Override
	public CommentDTO updateComment(Long infoId, long commentId, CommentDTO commentRequest) {
		
		Info info = inforepository.findById(infoId).orElseThrow(() -> new ResourceNotFoundException("Info", "id", infoId));
		
		Comment comment = commentrepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "id", commentId));
		comment.setInfo(info);
		
		comment.setName(commentRequest.getName());
		comment.setComment(commentRequest.getComment());
		
		Comment updateComment = commentrepository.save(comment);
		return mapToDTO(updateComment);
	}

	@Override
	public void deletedComment(Long infoId, Long commentId) {

		Info info = inforepository.findById(infoId).orElseThrow(() -> new ResourceNotFoundException("Info", "id", infoId));
		
		Comment comment = commentrepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "id", commentId));
		comment.setInfo(info);
		commentrepository.delete(comment);
	}

	
	
}
