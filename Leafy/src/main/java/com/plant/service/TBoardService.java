package com.plant.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.plant.dto.TBoardDTO;
import com.plant.mapper.TBoardMapper;

@Service
public class TBoardService { // 팁 게시판 서비스
	private TBoardMapper tbMapper;

	public TBoardService(TBoardMapper tbMapper) {
		super();
		this.tbMapper = tbMapper;
	}

	public ArrayList<TBoardDTO> selectAllTBoard(int pageNo) {
		return tbMapper.selectAllTBoard(pageNo);
	}

	public int selectTBoardCount() {
		return tbMapper.selectTBoardCount();

	}

	public List<TBoardDTO> selectTBoard(String kind, String search) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("search", search);
		return tbMapper.selectTBoard(map);
	}

	public ArrayList<TBoardDTO> selectAllTip(int pageNo) {
		return tbMapper.selectAllTip(pageNo);
	}

	


	
}
