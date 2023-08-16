package com.example.information.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.information.dto.InfoDTO;
import com.example.information.entity.Info;
import com.example.information.exception.ResourceNotFoundException;
import com.example.information.repository.InfoRepository;
import com.example.information.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService{

	private InfoRepository inforepository;
	
	
	public InfoServiceImpl(InfoRepository inforrepository) {
		super();
		this.inforepository = inforrepository;
	}


	@Override
	public InfoDTO createPost(InfoDTO infoDTO) {
		Info info = mapToEntity(infoDTO);
		
		Info newInfo = inforepository.save(info);
		
		//convert entity to DTO
		InfoDTO infoResponse = mapToDTO(newInfo);
		return infoResponse;
	}


	@Override
	public List<InfoDTO> getAllInfo() {
		List<Info> infos = inforepository.findAll();
		return infos.stream().map(info -> mapToDTO(info)).collect(Collectors.toList());
	}

	private InfoDTO mapToDTO(Info info) {
		InfoDTO infoDTO = new InfoDTO();
		infoDTO.setId(info.getId());
		infoDTO.setName(info.getName());
		infoDTO.setEmail(info.getEmail());
		infoDTO.setAddress(info.getAddress());
		return infoDTO;
	}

	private Info mapToEntity(InfoDTO infoDTO) {
		Info info = new Info();
		info.setName(infoDTO.getName());
		info.setEmail(infoDTO.getEmail());
		info.setAddress(infoDTO.getAddress());
		return info;
	}
	@Override
	public InfoDTO getInfoById(long id) {
		Info info = inforepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Info", "id", id));
		return mapToDTO(info);
	}


	@Override
	public InfoDTO updatedInfo(InfoDTO infoDTO, long id) {
		Info info = inforepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Info", "id", id));;
		info.setName(infoDTO.getName());
		info.setEmail(infoDTO.getEmail());
		info.setAddress(infoDTO.getAddress());
		Info updateInfo = inforepository.save(info);
		return mapToDTO(updateInfo);
	}


	@Override
	public void deletedPostById(long id) {
		Info info = inforepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Info", "id", id));;
		inforepository.delete(info);
		
	}

}
