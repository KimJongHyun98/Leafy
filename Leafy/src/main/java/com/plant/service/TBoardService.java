package com.plant.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.plant.dto.TBCommentDTO;
import com.plant.dto.TBoardDTO;
import com.plant.dto.TFileDTO;
import com.plant.mapper.TBoardMapper;

@Service
public class TBoardService { // 팁 게시판 서비스
	private TBoardMapper tbMapper;

	public TBoardService(TBoardMapper tbMapper) {
		super();
		this.tbMapper = tbMapper;
	}

	public ArrayList<TBoardDTO> selectAllTip(int pageNo) {
		return tbMapper.selectAllTip(pageNo);
	}

	
	public List<TBoardDTO> selectTBoard(String kind, String search, int currentPageNo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("search", search);
		map.put("pageNo", currentPageNo);

		return tbMapper.selectTipBoard(map);
	}

	public int selectTipBoardSearchCount(String kind, String search) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("search", search);
		
		return tbMapper.selectTipBoardSearchCount(map);
	}
	public int insertTipBoard(TBoardDTO dto) {
		int tno = tbMapper.selectTipBoardNo();
		dto.setTno(tno);
		tbMapper.insertTipBoard(dto);
		return tno;
	}
	//이미지 파일 업로드 - ckeditor
	public int insertFileOne(TFileDTO dto) {
		int fno = tbMapper.selectFileNo();
		dto.setTno(fno);
		tbMapper.insertFileOne(dto);
		return fno;
	}
	
	public void insertFileList(ArrayList<TFileDTO> flist) {
		for(int i=0;i<flist.size();i++) {
			tbMapper.insertFileInfo(flist.get(i));
		}
	}

	public TBoardDTO selectTipBoardContent(int tno) {
		return tbMapper.selectTipBoardContent(tno);
	}

	public ArrayList<TFileDTO> selectFileList(int tno) {
		return tbMapper.selectFileList(tno);
	}

	public TFileDTO selectFile(int tfno) {
		return tbMapper.selectFile(tfno);
	}

	public void deleteTipBoard(int tno) {
		tbMapper.deleteTipBoard(tno);
	}

	public void updateTipBoard(int tno, String tip_title, String tip_content) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("tno", tno);
		map.put("tip_title", tip_title);
		map.put("tip_content",tip_content);
		tbMapper.updateTipBoard(map);		
	}

	public int selectTipBoardCount() {
		return tbMapper.selectTipBoardCount();

	}

	public void addTipBoardCount(int tno) {
		tbMapper.addTipBoardCount(tno);
	}
	
	public List<TBCommentDTO> selectTipBoardComment(int tno) {
		return tbMapper.selectTipBoardComment(tno);
	}

	public TBCommentDTO insertTipComment(TBCommentDTO dto) {
		return tbMapper.insertTipComment(dto);
	}
	public boolean insertTipRecommand(int tno, String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("tno", tno);
		int count=0;
		try {
			count = tbMapper.insertTipBoardRecommand(map);
		} catch (Exception e) {
			System.out.println("게시글 추천을 이미 하였습니다.");
		}
		if(count==0)
			tbMapper.deleteTipBoardRecommand(map);
		return count==1;
	}

}
