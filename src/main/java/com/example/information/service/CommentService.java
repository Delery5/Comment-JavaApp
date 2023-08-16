package com.example.information.service;



import java.util.List;

import com.example.information.dto.CommentDTO;

public interface CommentService {

	CommentDTO createComment(long infoId, CommentDTO commentDTO);
	
	List<CommentDTO> getCommentsByInfoId(long infoId);
	
	CommentDTO getCommentById(Long infoId, Long commentId);
	
	CommentDTO updateComment(Long infoId, long commentId, CommentDTO commentRequest);

	void deletedComment(Long infoId, Long commentId);
}
