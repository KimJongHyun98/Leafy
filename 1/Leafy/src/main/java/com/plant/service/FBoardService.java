package com.plant.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.plant.dto.FBCommentDTO;
import com.plant.dto.FBoardDTO;
import com.plant.mapper.FBoardMapper;

@Service
public class FBoardService { // 자유게시판 서비스
	private FBoardMapper fbMapper;

	public FBoardService(FBoardMapper fbMapper) {
		this.fbMapper = fbMapper;
	}

	public ArrayList<FBoardDTO> selectAllFBoard(int pageNo) {
		return fbMapper.selectAllFBoard(pageNo);
	}

	public int selectFBoardCount() {
		return fbMapper.selectFBoardCount();
	}

	public ArrayList<FBoardDTO> selectFBoard(String kind, String search, int currentPageNo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("search", search);
		map.put("pageNo", currentPageNo);
		
		return fbMapper.selectFBoard(map);
	}

	public int selectFBoardSearchCount(String kind, String search) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("search", search);
		
		return fbMapper.selectFBoardSearchCount(map);
	}

	public FBoardDTO selectFBoardContent(int fb_no) {
		return fbMapper.selectFBoardContent(fb_no);
	}

	public List<FBCommentDTO> selectFBoardComment(int fb_no) {
		return fbMapper.selectFBoardComment(fb_no);
	}

	public FBCommentDTO insertFBComment(FBCommentDTO fbcdto) {
		return fbMapper.insertFBComment(fbcdto);
	}

	public void addFBoardCount(int fb_no) {
		fbMapper.addFBoardCount(fb_no);
	}

	public boolean insertFBoardRecommand(int fb_no, String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("fb_no", fb_no);
		int count=0;
		try {
			count = fbMapper.insertFBoardRecommand(map);
		} catch (Exception e) {
			System.out.println("게시글 추천을 이미 하였습니다.");
		}
		if(count==0)
			fbMapper.deleteFBoardRecommand(map);
		return count==1;
	}

	
	
}
