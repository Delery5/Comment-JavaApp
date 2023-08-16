package com.example.information.service;



import java.util.List;

import com.example.information.dto.InfoDTO;

public interface InfoService {

	InfoDTO createPost(InfoDTO infoDTO);
	
	List<InfoDTO> getAllInfo();
	
	InfoDTO getInfoById(long id);
	
	InfoDTO updatedInfo(InfoDTO infoDTO, long id);
	
	void deletedPostById(long id);
}
