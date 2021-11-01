package com.plant.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.plant.dto.FBCommentDTO;
import com.plant.dto.FBFileDTO;
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

	public int insertFBComment(FBCommentDTO fbcdto) {
		return fbMapper.insertFBComment(fbcdto);
	}

	public void addFBoardCount(int fb_no) {
		fbMapper.addFBoardCount(fb_no);
	}

	public boolean insertFBoardRecommand(int fb_no, String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("fb_no", fb_no);
		map.put("id", id);
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

	public int insertFBoard(FBoardDTO fbdto) {
		int fb_no = fbMapper.selectFBoardNo();
		fbdto.setFb_no(fb_no);
		fbMapper.insertFBoard(fbdto);
		return fb_no;
	}

	public void insertFileList(ArrayList<FBFileDTO> flist) {
		for(int i=0;i<flist.size();i++) {
			fbMapper.insertFileInfo(flist.get(i));
		}
	}

	public ArrayList<FBFileDTO> selectFileList(int fb_no) {
		return fbMapper.selectFileList(fb_no);
	}

	public FBFileDTO selectFile(int fb_fno) {
		return fbMapper.selectFile(fb_fno);
	}

	public void updateFBoard(int fb_no, String fb_title, String fb_content) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("fb_no", fb_no);
		map.put("fb_title", fb_title);
		map.put("fb_content", fb_content);
		System.out.println(map.toString());
		fbMapper.updateFBoard(map);
	}

	public void deleteFBoard(int fb_no) {
		fbMapper.deleteFBoard(fb_no);
		
	}

	public void deleteFBComment(int fbc_no) {
		fbMapper.deleteFBComment(fbc_no);
	}
	
}
