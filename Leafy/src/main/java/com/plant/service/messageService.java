package com.plant.service;

import org.springframework.stereotype.Service;

import com.plant.mapper.MessageMapper;

@Service
public class messageService {
	
	private MessageMapper msMapper;

	public messageService(MessageMapper msMapper) {
		this.msMapper = msMapper;
	}
	
	
}
