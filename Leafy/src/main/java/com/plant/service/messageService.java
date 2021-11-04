package com.plant.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.plant.dto.messageDTO;
import com.plant.mapper.MessageMapper;

@Service
public class messageService {
	
	private MessageMapper msMapper;

	public messageService(MessageMapper msMapper) {
		this.msMapper = msMapper;
	}
	
	public ArrayList<messageDTO> messageList(messageDTO dto){
		return msMapper.messageList(dto);
	}
}
