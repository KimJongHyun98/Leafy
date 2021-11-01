package com.plant.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.plant.dto.PCBoardDTO;
import com.plant.mapper.PCBoardMapper;

@Service
public class PCBoardService { // 분양게시판 서비스
	private PCBoardMapper pcbMapper;

	public PCBoardService(PCBoardMapper pcbMapper) {
		super();
		this.pcbMapper = pcbMapper;
	}

	public ArrayList<PCBoardDTO> selectAllPCBoard(int page) {
		return pcbMapper.selectAllPCBoard(page);
	}

	public int selectPCBoardCount() {
		return pcbMapper.selectPCBoardCount();

	}

/*	
	public static int selectPCBoardCount() {
		return 0;
	}
*/

	public static ArrayList<PCBoardDTO> selectPCBoard(String kind, String search) {
		return null;
	}
	
}
