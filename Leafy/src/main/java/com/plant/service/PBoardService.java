package com.plant.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.plant.dto.PBCommentDTO;
import com.plant.dto.PBFileDTO;
import com.plant.dto.PBoardDTO;
import com.plant.mapper.PBoardMapper;

@Service
public class PBoardService { // 포토게시판 서비스
	private PBoardMapper pbMapper;

	public PBoardService(PBoardMapper pbMapper) {
		super();
		this.pbMapper = pbMapper;
	}

	public ArrayList<PBoardDTO> selectAllPBoard(int pageNo) {
		return pbMapper.selectAllPBoard(pageNo);
	}

	public ArrayList<PBoardDTO> selectMVPBoard() {
		return pbMapper.selectMVPBoard();
	}

	public int selectPBoardCount() {
		return pbMapper.selectPBoardCount();
	}

	public ArrayList<PBoardDTO> selectPBoard(String kind, String search, int currentPageNo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("search", search);
		map.put("pageNo", currentPageNo);
		return pbMapper.selectPBoard(map);
	}

	public int selectPBoardSearchCount(String kind, String search) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("search", search);
		
		return pbMapper.selectPBoardSearchCount(map);
	}

	public void addPBoardCount(int pb_no) {
		pbMapper.addPBoardCount(pb_no);
	}

	public PBoardDTO selectPBoardContent(int pb_no) {
		return pbMapper.selectPBoardContent(pb_no);
	}

	public ArrayList<PBFileDTO> selectFileList(int pb_no) {
		return pbMapper.selectFileList(pb_no);
	}

	public PBFileDTO selectFile(int pb_fno) {
		return pbMapper.selectFile(pb_fno);
	}

	public ArrayList<PBCommentDTO> selectPBoardComment(int pb_no) {
		return pbMapper.selectPBoardComment(pb_no);
	}

	public int insertPBComment(PBCommentDTO pbcdto) {
		return pbMapper.insertPBComment(pbcdto);
	}

	public void deletePBComment(int pbc_no) {
		pbMapper.deletePBComment(pbc_no);
	}

	public int insertPBoard(PBoardDTO pbdto) {
		int pb_no = pbMapper.selectPBoardNo();
		pbdto.setPb_no(pb_no);
		pbMapper.insertPBoard(pbdto);
		return pb_no;
	}

	public void insertFileList(ArrayList<PBFileDTO> flist) {
		for(int i=0;i<flist.size();i++) {
			pbMapper.insertFileInfo(flist.get(i));
		}
	}

	public void updatePBoard(int pb_no, String pb_title, String pb_content) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pb_no", pb_no);
		map.put("pb_title", pb_title);
		map.put("pb_content", pb_content);
		pbMapper.updatePBoard(map);
	}

	public void deletePBoard(int pb_no) {
		pbMapper.deletePBoard(pb_no);
	}

	public boolean insertPBoardRecommand(String id, int pb_no) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pb_no", pb_no);
		int count = 0;
		try {
			count = pbMapper.insertPBoardRecommand(map);
		} catch (Exception e) {
			System.out.println("게시글 추천을 이미 하였습니다.");
		}
		if(count==0)
			pbMapper.deletePBoardRecommand(map);
		return count==1;
	}

}
