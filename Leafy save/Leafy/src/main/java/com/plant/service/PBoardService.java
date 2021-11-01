package com.plant.service;

import org.springframework.stereotype.Service;

import com.plant.mapper.PBoardMapper;

@Service
public class PBoardService { // 포토게시판 서비스
	private PBoardMapper pbMapper;

	public PBoardService(PBoardMapper pbMapper) {
		super();
		this.pbMapper = pbMapper;
	}


}
